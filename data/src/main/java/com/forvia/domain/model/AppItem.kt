package com.forvia.domain.model

data class AppItem(
    val id: Long, //Should never be empty
    val name: String?,
    val packageName: String?, //Should never be null
    val appIcon: String?,
    val appGraphic: String?,
    val versionName: String?,
    val downloads: Long,
    val updated: String?
)
