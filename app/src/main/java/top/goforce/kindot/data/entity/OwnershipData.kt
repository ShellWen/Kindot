package top.goforce.kindot.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class OwnershipData(
    @SerialName("hasMoreItems")
    val hasMoreItems: Boolean,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("numberOfItems")
    val numberOfItems: Int,
    @SerialName("success")
    val success: Boolean
)

@Serializable
data class Item(
    @SerialName("acquiredDate")
    val acquiredDate: String,
    @SerialName("acquiredTime")
    val acquiredTime: Long,
    @SerialName("allowedVersion")
    val allowedVersion: String,
    @SerialName("asin")
    val asin: String,
    @SerialName("authors")
    val authors: String,
    @SerialName("canLoan")
    val canLoan: Boolean,
    @SerialName("capabilityList")
    val capabilityList: List<String>,
    @SerialName("category")
    val category: String,
    @SerialName("collectionCount")
    val collectionCount: Int,
//  不清楚 collectionList 的数据类型，用不到，注释掉先
//  @SerialName("collectionList")
//  val collectionList: List<Any>,
    @SerialName("contentCategoryType")
    val contentCategoryType: String,
    @SerialName("dpURL")
    val dpURL: String,
    @SerialName("excludedDeviceMap")
    val excludedDeviceMap: DeviceMap,
    @SerialName("expiredPublicLibraryLending")
    val expiredPublicLibraryLending: Boolean,
    @SerialName("getOrderDetails")
    val getOrderDetails: Boolean,
    @SerialName("isAudibleOwned")
    val isAudibleOwned: Boolean,
    @SerialName("isContentValid")
    val isContentValid: Boolean,
    @SerialName("isDeleteRestrictionEnabled")
    val isDeleteRestrictionEnabled: Boolean,
    @SerialName("isGift")
    val isGift: Boolean,
    @SerialName("isGiftOption")
    val isGiftOption: Boolean,
    @SerialName("isInstitutionalRental")
    val isInstitutionalRental: Boolean,
    @SerialName("isKCRSupported")
    val isKCRSupported: Boolean,
    @SerialName("isNellOptimized")
    val isNellOptimized: Boolean,
    @SerialName("isPrimeShared")
    val isPrimeShared: Boolean,
    @SerialName("isPurchased")
    val isPurchased: Boolean,
    @SerialName("isUpdateAvailable")
    val isUpdateAvailable: String,
    @SerialName("orderDetailURL")
    val orderDetailURL: String,
    @SerialName("orderId")
    val orderId: String,
    @SerialName("originType")
    val originType: String,
    @SerialName("productImage")
    val productImage: String,
    @SerialName("readStatus")
    val readStatus: String,
    @SerialName("refundEligibility")
    val refundEligibility: Boolean,
    @SerialName("renderDownloadElements")
    val renderDownloadElements: Boolean,
    @SerialName("showProductDetails")
    val showProductDetails: Boolean,
    @SerialName("sortableAuthors")
    val sortableAuthors: String,
    @SerialName("sortableTitle")
    val sortableTitle: String,
    @SerialName("statusFromPlatformSearch")
    val statusFromPlatformSearch: String,
    @SerialName("targetDevices")
    val targetDevices: DeviceMap,
    @SerialName("title")
    val title: String,
    @SerialName("udlCategory")
    val udlCategory: String
)

typealias DeviceMap = Map<String, Int>