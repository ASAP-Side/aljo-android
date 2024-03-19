package team.asap.remote.service

import retrofit2.http.POST

interface DummyService {

    @POST("api/v1/dummy")
    suspend fun dummy(): String

}