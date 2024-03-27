package team.asap.aljo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import team.asap.aljo.domain.login.model.LoginType
import team.asap.aljo.login.KakaoLoginProvider
import team.asap.aljo.login.LoginViewModel
import team.asap.aljo.login.addLoginNavigator
import team.asap.aljo.navigation.NavigationManager
import team.asap.aljo.navigation.NavigationType
import team.asap.aljo.navigation.directions.LoginNavigationCommand
import team.asap.aljo.theme.AsapTheme
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var kakaoLoginProvider: KakaoLoginProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AsapTheme {
                BindNavigation(
                    navigationManager = navigationManager,
                    navController = navController,
                )
                NavHost(navController = navController, startDestination = LoginNavigationCommand.destination) {
                    addLoginNavigator()
                }
            }
        }
    }

    @Composable
    fun BindNavigation(
        navigationManager: NavigationManager,
        navController: NavHostController,
    ) {
        LaunchedEffect(navigationManager) {
            navigationManager.commands.flowWithLifecycle(
                lifecycle = this@MainActivity.lifecycle,
                minActiveState = Lifecycle.State.CREATED
            ).onEach {
                Timber.d("navcontroller:$navController $it")
                when (it.type) {
                    NavigationType.NAVIGATE -> navController.navigate(it.destination)
                    NavigationType.POP_BACK -> navController.popBackStack()
                }
            }.launchIn(this)
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
