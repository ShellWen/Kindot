package top.goforce.kindot.data.network

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

fun OkHttpClient.newCall(callUrl: String, buildBlock: Request.Builder.() -> Unit = {}): Call {
    val builder = Request.Builder().url(callUrl)
    builder.buildBlock()
    return newCall(builder.build())
}
