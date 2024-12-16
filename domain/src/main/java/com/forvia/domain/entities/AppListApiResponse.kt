package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AppListApiResponse(
    @SerialName("status") var status: String? = null,
    @SerialName("responses") var responses: Responses? = Responses()
)