package team.asap.aljo.di.datasource.remote

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.data.datasource.remote.DummyDataSource
import team.asap.remote.datasource.DummyDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Binds
    @Singleton
    abstract fun bindsDummyDataSource(remoteDataSource: DummyDataSourceImpl): DummyDataSource

}
