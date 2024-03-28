package team.asap.aljo.local.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.local.database.DummyDatabase
import team.asap.aljo.local.database.dao.DummyDAO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DummyDatabase =
        Room.databaseBuilder(
            context = context,
            klass = DummyDatabase::class.java,
            name = DummyDatabase.DATA_BASE_NAME
        ).build()

    @Provides
    fun provideAlarmDao(database: DummyDatabase): DummyDAO = database.dummyDAO()

}