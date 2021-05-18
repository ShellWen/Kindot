package top.goforce.kindot.data.network

import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import top.goforce.kindot.App
import top.goforce.kindot.data.CookiesKey.COOKIE_UBID_ACBCN
import top.goforce.kindot.data.CookiesKey.COOKIE_X_ACBCN
import top.goforce.kindot.ktx.cookiesDataStore

object NetworkClient {
    @Suppress("MemberVisibilityCanBePrivate")
    val client = OkHttpClient.Builder().cookieJar(AmazonCookieJar()).build()
}

class AmazonCookieJar : CookieJar {
    private val cookiesMap: MutableMap<String, MutableList<Cookie>> = mutableMapOf()
    private val xAcbcn = Transformations.map(App.instance.cookiesDataStore.data.asLiveData()) {
        it[COOKIE_X_ACBCN]
    }

    private val ubidAcbcn = Transformations.map(App.instance.cookiesDataStore.data.asLiveData()) {
        it[COOKIE_UBID_ACBCN]
    }

    /**
     * Saves [cookies] from an HTTP response to this store according to this jar's policy.
     *
     * Note that this method may be called a second time for a single HTTP response if the response
     * includes a trailer. For this obscure HTTP feature, [cookies] contains only the trailer's
     * cookies.
     */
    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val host = url.host
        val cookiesList = cookiesMap[host]
        if (cookiesList != null) {
            cookiesMap.remove(host)
        }
        val cookiesFiltered = mutableListOf<Cookie>()
        cookies.map {
            // 不过滤会导致 Amazon 跳转到 /400 页面
            if (it.value != "-" && it.value != "") {
                cookiesFiltered += it
            }
        }
        cookiesMap[host] = cookiesFiltered

        // 不存储 Amazon Cookies，请求的时候加上就好
//        GlobalScope.launch {
//            cookiesFiltered.map {
//                if ("amazon" in it.domain) {
//                    when (it.name) {
//                        "x-acbcn" -> {
//                            App.instance.cookiesDataStore.edit { settings ->
//                                settings[COOKIE_X_ACBCN] = it.value
//                            }
//                        }
//                        "ubid-acbcn" -> {
//                            App.instance.cookiesDataStore.edit { settings ->
//                                settings[COOKIE_UBID_ACBCN] = it.value
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    /**
     * Load cookies from the jar for an HTTP request to [url]. This method returns a possibly
     * empty list of cookies for the network request.
     *
     * Simple implementations will return the accepted cookies that have not yet expired and that
     * [match][Cookie.matches] [url].
     */
    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val host = url.host
        val cookies = cookiesMap[host] ?: mutableListOf()
        if ("amazon" in host) {
            GlobalScope.launch {
                xAcbcn.value?.let {
                    if (it.isNotEmpty())
                        cookies += Cookie.Builder()
                            .domain(host)
                            .name("x-acbcn")
                            .value(it)
                            .secure()
                            .build()
                }
                ubidAcbcn.value?.let {
                    if (it.isNotEmpty())
                        cookies += Cookie.Builder()
                            .domain(host)
                            .name("ubid-acbcn")
                            .value(it)
                            .secure()
                            .build()
                }
            }
        }
        return cookies
    }
}