package team.asap.aljo.domain.login.repository

interface LoginRepository {
    suspend fun kakaoLogin(accessToken: String): Unit
}