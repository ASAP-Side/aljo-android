package team.asap.aljo.di.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import team.asap.aljo.navigation.NavigationManager
import team.asap.aljo.navigation.NavigationManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Singleton
    @Binds
    abstract fun bindNavigationManager(
        navigationManagerImpl: NavigationManagerImpl
    ): NavigationManager
}