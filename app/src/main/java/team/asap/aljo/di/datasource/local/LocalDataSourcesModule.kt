package team.asap.aljo.di.datasource.local

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.data.datasource.local.LocalDummyDataSource
import team.asap.aljo.local.datasource.LocalDummyDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourcesModule {

    @Binds
    @Singleton
    abstract fun bindsLocalDummyDataSource(localDataSource: LocalDummyDataSourceImpl): LocalDummyDataSource

}