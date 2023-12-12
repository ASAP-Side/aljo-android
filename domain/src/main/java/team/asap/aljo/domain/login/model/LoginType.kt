package team.asap.aljo.domain.login.model

sealed interface LoginType {
    data class Kakao(val accessToken: String) : LoginType
}