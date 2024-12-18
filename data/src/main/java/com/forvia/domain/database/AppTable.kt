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
    val name: String,

    @ColumnInfo(name = "packageName")
    val packageName: String,

    @ColumnInfo(name = "appIcon")
    val appIcon: String?,

    @ColumnInfo(name = "appGraphic")
    val appGraphic: String?,

    @ColumnInfo(name = "versionName")
    val versionName: String,

    @ColumnInfo(name = "downloads")
    val downloads: Int,

    @ColumnInfo(name = "updated")
    val updated: String
)
