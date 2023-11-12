package team.asap.aljo.domain.login.usecase

import team.asap.aljo.domain.auth.repsitory.AuthRepository
import team.asap.aljo.domain.login.model.LoginInfo
import team.asap.aljo.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val authRepository: AuthRepository,
) {
    suspend fun kakaoLogin(): LoginInfo {
        return loginRepository.kakaoLogin()
    }
}