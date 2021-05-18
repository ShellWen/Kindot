package top.goforce.kindot.data.network.service.impl

import okhttp3.OkHttpClient
import ru.gildor.coroutines.okhttp.await
import top.goforce.kindot.data.network.entity.LoginStatusEnum
import top.goforce.kindot.data.network.newCall
import top.goforce.kindot.data.network.service.AmazonService

class AmazonServiceImpl(private val client: OkHttpClient) : AmazonService {

    /**
     * 使用 判断是否重定向 的方法 判断登录状态
     *
     *
     * @return 是否为登录状态
     */
    override suspend fun checkLoginStatus(): LoginStatusEnum {
        val beforeUrl = "https://www.amazon.cn/hz/mycd/myx"

        return try {
            val response = client.newCall(beforeUrl).await()
            val afterUrl = response.request.url.toString()

            if ("/ap/signin" in afterUrl) {
                LoginStatusEnum.LOGOUT
            } else {
                LoginStatusEnum.LOGIN
            }
        } catch (e: Throwable) {
            e.printStackTrace()
            LoginStatusEnum.FAILED_NETWORK
        }
    }
}