package com.forvia.domain.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_table")
data class AppTable(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "packageName")
    val packageName: String? = null,

    @ColumnInfo(name = "appIcon")
    val appIcon: String? = null,

    @ColumnInfo(name = "appGraphic")
    val appGraphic: String? = null,

    @ColumnInfo(name = "versionName")
    val versionName: String? = null,

    @ColumnInfo(name = "downloads")
    val downloads: Long,

    @ColumnInfo(name = "updated")
    val updated: String? = null
)
