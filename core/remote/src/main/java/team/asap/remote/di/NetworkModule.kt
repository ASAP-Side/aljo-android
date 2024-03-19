package team.asap.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import team.asap.aljo.remote.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().setLevel(
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    )

    @Singleton
    @Provides
    fun provideOkHttpClient(logInterceptor: Interceptor): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(logInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS).build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.ALJO_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}
