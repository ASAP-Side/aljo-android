package team.asap.aljo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import team.asap.aljo.domain.common.exception.KakaoCanceledException
import team.asap.aljo.domain.common.exception.ThirdPartyException
import team.asap.aljo.domain.login.usecase.LoginUseCase
import team.asap.aljo.presentation.login.LoginScreen
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onClickLoginButton = ::kakaoLogin)
        }
    }

    private fun kakaoLogin() = lifecycleScope.launch {
        runCatching {
            loginUseCase.kakaoLogin()
        }.onFailure { throwable: Throwable ->
            if (throwable is KakaoCanceledException) {
                return@onFailure
            }
        }
    }
}