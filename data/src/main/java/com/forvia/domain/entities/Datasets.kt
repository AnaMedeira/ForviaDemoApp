package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Datasets(

    @SerialName("all") var all: All? = All()

)