package team.asap.aljo.data.datasource.local

interface LocalDummyDataSource {

    suspend fun dummy(): String

    suspend fun saveDummy()

}