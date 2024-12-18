package com.forvia.domain.mapper

import com.forvia.domain.database.AppTable
import com.forvia.domain.entities.List
import com.forvia.domain.model.AppItem

fun List.toDomain(): AppItem = AppItem(
    id = id,
    name = name,
    packageName = packageName,
    appIcon = icon,
    appGraphic = graphic,
    versionName = vername,
    downloads = downloads,
    updated = updated
)

fun AppItem.toAppTable(): AppTable = AppTable(
    id = id,
    name = name,
    packageName = packageName,
    appIcon = appIcon,
    appGraphic = appGraphic,
    versionName = versionName,
    downloads = downloads,
    updated = updated
)

fun AppTable.toAppTable(): AppItem = AppItem(
    id = id,
    name = name,
    packageName = packageName,
    appIcon = appIcon,
    appGraphic = appGraphic,
    versionName = versionName,
    downloads = downloads,
    updated = updated
)
