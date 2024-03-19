package team.asap.aljo.local.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.local.datastore.PreferenceProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    @Singleton
    fun providesAppPreferences(provider: PreferenceProvider): SharedPreferences = provider.create()

}
