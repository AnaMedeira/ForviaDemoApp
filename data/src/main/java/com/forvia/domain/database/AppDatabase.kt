package com.forvia.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AppTable::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun AppDao(): AppDao
}