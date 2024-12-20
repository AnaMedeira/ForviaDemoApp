package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class List(
    @SerialName("id") var id: Long,
    @SerialName("name") var name: String,
    @SerialName("package") var packageName: String,
    @SerialName("store_id") var storeId: Int? = null,
    @SerialName("store_name") var storeName: String? = null,
    @SerialName("vername") var vername: String,
    @SerialName("vercode") var vercode: Int? = null,
    @SerialName("md5sum") var md5sum: String? = null,
    @SerialName("apk_tags") var apkTags: ArrayList<String> = arrayListOf(),
    @SerialName("size") var size: Int? = null,
    @SerialName("downloads") var downloads: Int,
    @SerialName("pdownloads") var pdownloads: Int? = null,
    @SerialName("added") var added: String? = null,
    @SerialName("modified") var modified: String? = null,
    @SerialName("updated") var updated: String,
    @SerialName("rating") var rating: Float? = null,
    @SerialName("icon") var icon: String? = null,
    @SerialName("graphic") var graphic: String? = null,
    @SerialName("uptype") var uptype: String? = null
)