package top.goforce.kindot.data.repos

import androidx.lifecycle.LiveData
import top.goforce.kindot.data.network.entity.LoginStatusEnum

interface CookiesRepos {
    fun getLoginStatus(): LiveData<LoginStatusEnum>

    fun getLoginStatusReadableText(): LiveData<String>

    suspend fun refreshLoginStatus()
}