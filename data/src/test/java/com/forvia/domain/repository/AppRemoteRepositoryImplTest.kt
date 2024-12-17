package com.forvia.domain.repository


import androidx.test.filters.SmallTest
import com.forvia.domain.api.AppApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@SmallTest
class AppRemoteRepositoryImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var repository: AppRemoteRepository

    private val bodyResponse = """{
                    "status":"OK",
                    "responses":{
                       "listApps":{
                          "info":{},
                          "datasets":{
                             "all":{
                                "info":{
                                 
                                },
                                "data":{
                           
                                   "list":[
                                      {
                                         "id":1,
                                         "name":"App 1",
                                         "package":"com.app.one",
                                         "store_name":"store_name",
                                         "vername":"1.0.1"
                                         "downloads":1,
                                         "updated":"2024-12-16 11:08:01",
                                         "rating":0,
                                         "icon":"https://pool.img.aptoide.com/catappult/a06c5b55b9a1cb47018e697ec3df7c05_icon.png",
                                         "graphic":"https://pool.img.aptoide.com/catappult/f63447315af38bbbae12c5ae53fbe767_feature_graphic.png"
                                      },
                                      {
                                         "id":2,
                                         "name":"App 2",
                                         "package":"com.app.two",
                                         "store_name":"store_name",
                                         "vername":"1.0.2",
                                         "downloads":10,
                                         "updated":"2024-12-16 11:02:30",
                                         "rating":0,
                                         "icon":"https://pool.img.aptoide.com/catappult/1435285e82f35d22dda815641f78bae8_icon.png",
                                         "graphic":"https://pool.img.aptoide.com/catappult/05faf8ec6510ea26a29e102fa6e1e170_feature_graphic.png"
                                      }
                                   ]
                                }
                             }
                          }
                       }
                    }
                }""".trimIndent()

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        // Provide MockWebServer's URL to Retrofit
        val api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(AppApi::class.java)

        // Initialize the repository
        repository = AppRemoteRepositoryImpl(api)

    }

    @Test
    fun `getApps returns list of apps`() = runTest {
        val mockResponse = MockResponse()
            .setBody(bodyResponse)
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val apps = repository.getApps()
        assertEquals(2, apps.size)
        assertEquals("App 1", apps.get(0).name)

    }

    @Test
    fun `getApps throws exception when API call fails`() = runTest {

        val mockResponse = MockResponse().setResponseCode(500)
        mockWebServer.enqueue(mockResponse)

        try {
            repository.getApps()
            assert(false) { "Expected exception was not thrown" }
        } catch (e: Exception) {
            assertEquals("HTTP 500 Server Error", e.message)
        }
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}