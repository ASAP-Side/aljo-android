package team.asap.aljo.domain.login.repository

import team.asap.aljo.domain.login.model.LoginInfo

interface LoginRepository {
    suspend fun kakaoLogin(): LoginInfo
}