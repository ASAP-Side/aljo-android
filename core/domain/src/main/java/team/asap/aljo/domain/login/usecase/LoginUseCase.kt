package team.asap.aljo.domain.login.usecase

import team.asap.aljo.domain.login.model.LoginType
import team.asap.aljo.domain.login.repository.LoginRepository
import javax.inject.Inject

//@ActivityScoped
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(loginType: LoginType) {
        when (loginType) {
            is LoginType.Kakao -> loginRepository.kakaoLogin(loginType.accessToken)
        }

    }
}
