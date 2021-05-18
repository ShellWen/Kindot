package top.goforce.kindot.data.network.service

import top.goforce.kindot.data.network.entity.LoginStatusEnum

interface AmazonService {
    suspend fun checkLoginStatus(): LoginStatusEnum
}