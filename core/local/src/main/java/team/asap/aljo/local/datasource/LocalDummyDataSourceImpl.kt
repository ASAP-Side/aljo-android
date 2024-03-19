package team.asap.aljo.local.datasource

import team.asap.aljo.data.datasource.local.LocalDummyDataSource
import javax.inject.Inject

class LocalDummyDataSourceImpl @Inject constructor(

) : LocalDummyDataSource {

    override suspend fun dummy(): String {
        return "LocalDummyDataSourceImpl"
    }

}