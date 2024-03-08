package team.asap.aljo.data.login.repository

import team.asap.aljo.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(

) : LoginRepository {
    override suspend fun kakaoLogin(accessToken: String) {
    }
}