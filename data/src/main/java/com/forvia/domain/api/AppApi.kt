package com.forvia.domain.api

import com.forvia.domain.entities.AppListApiResponse
import retrofit2.http.GET

interface AppApi {
    @GET("api/6/bulkRequest/api_list/listApps")
    suspend fun getAppList(): AppListApiResponse
}