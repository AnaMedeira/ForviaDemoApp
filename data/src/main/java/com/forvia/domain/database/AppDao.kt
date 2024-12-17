package com.forvia.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Query("SELECT * FROM app_table")
    suspend fun getAllApps(): List<AppTable>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveApps(table: AppTable)
}