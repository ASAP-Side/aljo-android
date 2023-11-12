package team.asap.aljo.app

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp
import team.asap.aljo.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class AljoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKakaoLogin()
    }

    private fun initTimber(){
        if(BuildConfig.DEBUG){
            Timber.DebugTree()
        }
    }

    private fun initKakaoLogin(){
       KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }
}