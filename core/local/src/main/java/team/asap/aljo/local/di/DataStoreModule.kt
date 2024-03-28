package team.asap.aljo.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.local.datastore.DummyDataStore
import team.asap.aljo.local.datastore.DummyDataStoreImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Binds
    @Singleton
    abstract fun bindsDummyDataStore(dummyDataStore: DummyDataStoreImpl): DummyDataStore

}
