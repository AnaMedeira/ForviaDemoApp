package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Info(

    @SerialName("status") var status: String? = null,
    @SerialName("time") var time: Time? = Time()

)