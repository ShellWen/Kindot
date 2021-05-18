package top.goforce.kindot

import android.app.Application
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import top.goforce.kindot.data.network.NetworkClient
import top.goforce.kindot.data.network.service.AmazonService
import top.goforce.kindot.data.network.service.impl.AmazonServiceImpl
import top.goforce.kindot.data.repos.CookiesRepos
import top.goforce.kindot.data.repos.impl.CookiesReposImpl
import java.util.logging.Logger

class App : Application() {
    companion object {
        lateinit var instance: App
            internal set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        Logger.getLogger(OkHttpClient::class.java.name).level = java.util.logging.Level.FINE

        startKoin {
            // TODO
            // Koin 有一个严重的 bug，会导致 Kotlin 升级到 1.5.0 之后启动 crash
            // 参考：https://github.com/InsertKoinIO/koin/issues/1076
            // 目前的临时修复方法是把日志等级拉到 NONE，即不打印日志
            androidLogger(org.koin.core.logger.Level.NONE)
            androidContext(this@App)
            modules(appModule)
        }
    }
}

val appModule = module {
    single { NetworkClient.client }

    single<AmazonService> { AmazonServiceImpl(get()) }

    single<CookiesRepos> { CookiesReposImpl(get()) }
}