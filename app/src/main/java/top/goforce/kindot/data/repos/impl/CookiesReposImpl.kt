package top.goforce.kindot.data.repos.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import top.goforce.kindot.data.network.entity.LoginStatusEnum
import top.goforce.kindot.data.network.entity.readableText
import top.goforce.kindot.data.network.service.AmazonService
import top.goforce.kindot.data.repos.CookiesRepos

class CookiesReposImpl(private val amazonService: AmazonService) : CookiesRepos {
    private var currentLoginStatus: MutableLiveData<LoginStatusEnum> =
        MutableLiveData(LoginStatusEnum.NEED_REFRESH)

    override fun getLoginStatus(): LiveData<LoginStatusEnum> {
        return currentLoginStatus
    }

    override fun getLoginStatusReadableText(): LiveData<String> =
        Transformations.map(currentLoginStatus) {
            currentLoginStatus.value?.readableText
        }

    override suspend fun refreshLoginStatus() {
        currentLoginStatus.postValue(LoginStatusEnum.REFRESHING)
        currentLoginStatus.postValue(amazonService.checkLoginStatus())
    }
}