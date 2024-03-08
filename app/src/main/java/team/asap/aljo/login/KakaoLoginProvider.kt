package team.asap.aljo.login

import android.content.Context
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

// ref. https://developers.kakao.com/docs/latest/ko/kakaologin/android
class KakaoLoginProvider @Inject constructor(
    @ActivityContext private val activityContext: Context,
) {
    suspend fun login(): OAuthToken {
        val isKakaoTalkInstalled = UserApiClient.instance.isKakaoTalkLoginAvailable(activityContext)
        return if (isKakaoTalkInstalled) {
            loginWithKakaoTalk()
        } else {
            loginWithWebView()
        }
    }

    private suspend fun loginWithKakaoTalk(): OAuthToken {
        return suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoTalk(activityContext) { token: OAuthToken?, error: Throwable? ->
                if (error != null) {
                    // 카카오 로그인 취소 에러는 사용자에 의해 발생하므로, 따로 예외를 던져주지 않음
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        continuation.cancel()
                    }
                    UserApiClient.instance.loginWithKakaoAccount(activityContext) { accountToken: OAuthToken?, accountError: Throwable? ->
                        when {
                            accountError != null -> {
                                continuation.resumeWithException(accountError)
                            }

                            accountToken != null -> {
                                continuation.resume(accountToken)
                            }
                        }
                    }
                } else if (token != null) {
                    continuation.resume(token)
                }
            }
        }
    }

    private suspend fun loginWithWebView(): OAuthToken {
        return suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoAccount(activityContext) { token: OAuthToken?, error: Throwable? ->
                when {
                    error != null -> {
                        continuation.resumeWithException(error)
                    }

                    token != null -> {
                        continuation.resume(token)
                    }
                }
            }
        }
    }
}