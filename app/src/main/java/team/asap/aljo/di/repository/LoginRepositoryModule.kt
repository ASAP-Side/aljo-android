package team.asap.aljo.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import team.asap.aljo.data.login.repository.LoginRepositoryImpl
import team.asap.aljo.domain.login.repository.LoginRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class LoginRepositoryModule {

    @Binds
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}