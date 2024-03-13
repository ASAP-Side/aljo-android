package team.asap.aljo.data.auth.repository

import team.asap.aljo.domain.auth.repsitory.AuthRepository
import team.asap.aljo.domain.login.model.LoginInfo
import team.asap.aljo.domain.user.model.User
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override fun signIn(loginInfo: LoginInfo): User {
        return User(
            id = 0,
            name = "dummy",
            profileImageUrl = "",
        )
    }
}