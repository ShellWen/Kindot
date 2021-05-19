package top.goforce.kindot.ui.me

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import top.goforce.kindot.base.BaseViewModel
import top.goforce.kindot.data.network.entity.LoginStatusEnum
import top.goforce.kindot.data.repos.CookiesRepos

class MeViewModel : BaseViewModel(), KoinComponent {
    private val cookiesRepos: CookiesRepos by inject()

    val loginStatus: LiveData<LoginStatusEnum> = getReposLoginStatus()
    val loginStatusReadableText: LiveData<String> = cookiesRepos.getLoginStatusReadableText()

    private fun getReposLoginStatus(): LiveData<LoginStatusEnum> {
        val reposLoginStatus = cookiesRepos.getLoginStatus()
        if (reposLoginStatus.value == LoginStatusEnum.NEED_REFRESH)
            refreshLoginStatus()
        return reposLoginStatus
    }

    fun refreshLoginStatus() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.i(TAG, "Login Status start refresh.")
                cookiesRepos.refreshLoginStatus()
                Log.i(TAG, "Login Status refreshed: ${loginStatus.value}")
            }
        }
    }
}