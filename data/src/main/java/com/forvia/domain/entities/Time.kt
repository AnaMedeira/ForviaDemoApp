package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Time(

    @SerialName("seconds") var seconds: Double? = null,
    @SerialName("human") var human: String? = null

)