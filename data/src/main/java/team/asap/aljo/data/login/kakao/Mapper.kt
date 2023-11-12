package team.asap.aljo.data.login.kakao

import com.kakao.sdk.auth.model.OAuthToken
import team.asap.aljo.domain.login.model.LoginInfo

fun OAuthToken.toDomain() = LoginInfo(
    accessToken = accessToken
)