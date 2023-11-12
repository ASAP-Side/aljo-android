package team.asap.aljo.data.login.repository

import team.asap.aljo.data.login.kakao.KakaoLoginProvider
import team.asap.aljo.data.login.kakao.toDomain
import team.asap.aljo.domain.login.model.LoginInfo
import team.asap.aljo.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val kakaoLoginProvider: KakaoLoginProvider,
) : LoginRepository {
    override suspend fun kakaoLogin(): LoginInfo {
        return kakaoLoginProvider.login().toDomain()
    }
}