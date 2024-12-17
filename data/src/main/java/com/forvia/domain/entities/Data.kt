package com.forvia.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Data(

    @SerialName("total") var total: Int? = null,
    @SerialName("offset") var offset: Int? = null,
    @SerialName("limit") var limit: Int? = null,
    @SerialName("next") var next: Int? = null,
    @SerialName("hidden") var hidden: Int? = null,
    @SerialName("list") var list: ArrayList<List> = arrayListOf()

)