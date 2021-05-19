package top.goforce.kindot.data.network.entity

import top.goforce.kindot.App
import top.goforce.kindot.R
import top.goforce.kindot.data.network.entity.LoginStatusEnum.*

enum class LoginStatusEnum {
    LOGON,
    LOGOUT,
    UNKNOWN,
    FAILED_NETWORK,
    NEED_REFRESH,
    REFRESHING,
}

val LoginStatusEnum.readableText: String
    get() = when (this) {
        LOGON -> App.instance.getString(R.string.login_status_logon)
        LOGOUT -> App.instance.getString(R.string.login_status_logout)
        UNKNOWN -> App.instance.getString(R.string.login_status_unknown)
        FAILED_NETWORK -> App.instance.getString(R.string.login_status_failed_network)
        NEED_REFRESH -> App.instance.getString(R.string.login_status_need_refresh)
        REFRESHING -> App.instance.getString(R.string.login_status_refreshing)
    }
