package top.goforce.kindot.data.repos.impl

import androidx.lifecycle.MutableLiveData
import top.goforce.kindot.data.network.entity.LoginStatusEnum
import top.goforce.kindot.data.network.service.AmazonService
import top.goforce.kindot.data.repos.CookiesRepos

class CookiesReposImpl(private val amazonService: AmazonService) : CookiesRepos {
    private var currentLoginStatus: MutableLiveData<LoginStatusEnum> =
        MutableLiveData(LoginStatusEnum.UNKNOWN)

    override fun getLoginStatus(): MutableLiveData<LoginStatusEnum> {
        return currentLoginStatus
    }

    override suspend fun refreshLoginStatus() {
        currentLoginStatus.postValue(amazonService.checkLoginStatus())
    }
}