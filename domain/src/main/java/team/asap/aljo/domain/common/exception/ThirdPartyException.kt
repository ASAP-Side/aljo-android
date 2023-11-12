package team.asap.aljo.domain.common.exception

sealed class ThirdPartyException(
    override val message: String?,
    val code: Int,
) : Throwable() {

    override fun toString(): String {
        return "ThirdPartyException message=[$message], code=[$code]"
    }
}

object KakaoCanceledException : ThirdPartyException(
    message = "사용자에 의한 카카오 로그인 취소",
    code = 100,
)


