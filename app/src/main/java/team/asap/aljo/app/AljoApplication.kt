package team.asap.aljo.app

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import team.asap.aljo.BuildConfig
import timber.log.Timber

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