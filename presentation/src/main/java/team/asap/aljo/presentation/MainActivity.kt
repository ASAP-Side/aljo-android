package team.asap.aljo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import team.asap.aljo.domain.login.usecase.LoginUseCase
import team.asap.aljo.presentation.login.LoginScreen
import team.asap.aljo.presentation.login.LoginViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var loginUseCase: LoginUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onClickLoginButton = {
                lifecycleScope.launch {
                    loginUseCase.kakaoLogin()
                }
            })
        }
    }
}