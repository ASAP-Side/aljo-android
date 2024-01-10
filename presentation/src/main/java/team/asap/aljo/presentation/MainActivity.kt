package team.asap.aljo.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import team.asap.aljo.domain.login.model.LoginType
import team.asap.aljo.presentation.login.KakaoLoginProvider
import team.asap.aljo.presentation.login.LoginScreen
import team.asap.aljo.presentation.login.LoginViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var kakaoLoginProvider: KakaoLoginProvider

    init {
        Log.d("context", "constructor [${this}]")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("context", "[${this}] baseContext[${this.baseContext}] [${viewModel}]")
        setContent {
            LoginScreen(onClickLoginButton = {
            })
        }
    }

    private fun kakaoLogin() { // 예외적으로 Activity 에서 비즈니스 로직 호출
        lifecycleScope.launch {
            kakaoLoginProvider.login().also {
                viewModel.login(LoginType.Kakao(it.accessToken))
            }
        }
    }
}
