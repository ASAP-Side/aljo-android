package team.asap.aljo.data.datasource.remote

interface DummyDataSource {

    suspend fun dummy(): String

}