package team.asap.aljo.local.datasource

import team.asap.aljo.data.datasource.local.LocalDummyDataSource
import team.asap.aljo.local.database.dao.DummyDAO
import team.asap.aljo.local.database.entity.DummyData
import javax.inject.Inject

class LocalDummyDataSourceImpl @Inject constructor(
    private val dummyDao: DummyDAO
) : LocalDummyDataSource {

    override suspend fun dummy(): String {
        return "LocalDummyDataSourceImpl"
    }

    override suspend fun saveDummy() {
        dummyDao.insert(
            entity = DummyData(
                id = 1,
                name = "Dummy"
            )
        )
    }

}