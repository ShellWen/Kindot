package top.goforce.kindot.data.repos

import androidx.lifecycle.MutableLiveData
import top.goforce.kindot.data.network.entity.LoginStatusEnum

interface CookiesRepos {
    fun getLoginStatus(): MutableLiveData<LoginStatusEnum>

    suspend fun refreshLoginStatus()
}