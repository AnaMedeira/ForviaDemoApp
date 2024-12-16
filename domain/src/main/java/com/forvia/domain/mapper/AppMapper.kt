package com.forvia.domain.mapper

import com.forvia.domain.entities.List
import com.forvia.domain.model.AppItem

fun List.toDomain(): AppItem = AppItem(
    id = id ?: 0,
    name = name,
    packageName = packageName,
    appIcon = icon,
    appGraphic = graphic,
    versionName = vername,
    downloads = downloads?.toLong() ?: 0L,
    updated = updated
)
