package top.goforce.kindot.data

import androidx.datastore.preferences.core.stringPreferencesKey

object CookiesKey {
    // x-acbcn
    val COOKIE_X_ACBCN = stringPreferencesKey("cookie_x_acbcn")
    // ubid-acbcn
    val COOKIE_UBID_ACBCN = stringPreferencesKey("cookie_ubid_acbcn")
    // x-acbcn 和 ubid-acbcn 用于亚马逊官网保持登陆状态，缺一不可
}