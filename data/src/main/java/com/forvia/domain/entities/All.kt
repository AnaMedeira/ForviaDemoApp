package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class All(
    @SerialName("info") var info: Info? = Info(),
    @SerialName("data") var data: Data? = Data()
)