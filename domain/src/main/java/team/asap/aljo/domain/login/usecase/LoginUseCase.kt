package team.asap.aljo.domain.login.usecase

import team.asap.aljo.domain.auth.repsitory.AuthRepository
import team.asap.aljo.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authRepository: AuthRepository,
) {
    suspend fun kakaoLogin() {
        val loginInfo = loginRepository.kakaoLogin()
        authRepository.signIn(loginInfo = loginInfo).also { user ->
            //user local 캐싱 등 작업 진행
        }
    }
}