package team.asap.remote.datasource

import team.asap.aljo.data.datasource.remote.DummyDataSource
import team.asap.remote.service.DummyService
import javax.inject.Inject

class DummyDataSourceImpl @Inject constructor(
    private val dummyService: DummyService
) : DummyDataSource {

    override suspend fun dummy(): String {
        return dummyService.dummy()
    }

}