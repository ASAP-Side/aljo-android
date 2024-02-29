package team.asap.aljo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import team.asap.aljo.domain.login.model.LoginType
import team.asap.aljo.presentation.login.KakaoLoginProvider
import team.asap.aljo.presentation.login.LoginViewModel
import team.asap.aljo.theme.AsapTheme
import team.asap.aljo.theme.AsapTheme.primary
import team.asap.aljo.theme.AsapTheme.typography
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var kakaoLoginProvider: KakaoLoginProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsapTheme {
                Text(
                    text = "test",
                    style = typography.pretendard(
                        15, FontWeight.Medium
                    ),
                    color = primary.red01,
                )
            }
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
