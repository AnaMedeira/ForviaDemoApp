package com.forvia.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class AppItem(
    val id: Long, //Should never be empty
    val name: String,
    val packageName: String,
    val appIcon: String?,
    val appGraphic: String?,
    val versionName: String,
    val downloads: Int,
    val updated: String
) : Parcelable
