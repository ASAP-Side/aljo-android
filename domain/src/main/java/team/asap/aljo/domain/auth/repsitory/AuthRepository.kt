package team.asap.aljo.domain.auth.repsitory

import team.asap.aljo.domain.login.model.LoginInfo
import team.asap.aljo.domain.user.model.User

interface AuthRepository {
    fun signIn(loginInfo: LoginInfo): User
}