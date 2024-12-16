package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ListApps(

    @SerialName("info") var info: Info? = Info(),
    @SerialName("datasets") var datasets: Datasets? = Datasets()

)