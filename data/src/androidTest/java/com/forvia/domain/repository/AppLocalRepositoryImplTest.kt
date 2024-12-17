package com.forvia.domain.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.forvia.domain.database.AppDao
import com.forvia.domain.database.AppDatabase
import com.forvia.domain.model.AppItem
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

//tests with Room must be executed as instrumentation text because the Application context is needed
@RunWith(AndroidJUnit4::class)
class AppLocalRepositoryImplTest {
    private lateinit var database: AppDatabase
    private lateinit var appDao: AppDao
    private lateinit var repository: AppLocalRepository

    @Before
    fun setupDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        appDao = database.AppDao()
        repository = AppLocalRepositoryImpl(appDao)
    }


    @Test
    fun insert() = runBlocking {
        val row = AppItem(
            id = 1,
            "App 1",
            "packageName 1",
            "App Icon 1",
            "App graphic 1",
            "version name 1",
            0L,
            "update 1"
        )
        repository.saveApps(row)

        val latch = CountDownLatch(1)
        val apps = repository.getApps()
        assert(apps.contains(row))
        latch.countDown()
    }

    @After
    fun closeDatabase() {
        database.close()
    }
}