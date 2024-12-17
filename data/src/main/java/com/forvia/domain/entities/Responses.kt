package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Responses(
    @SerialName("listApps") var listApps: ListApps? = ListApps()

)