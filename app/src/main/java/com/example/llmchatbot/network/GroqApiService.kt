package com.example.llmchatbot.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

// Request to YOUR backend
data class ChatRequest(val message: String)

// Response from YOUR backend
data class ChatResponse(val reply: String)

interface GroqApiService {

    @POST("chat")   // matches your server.js route: app.post('/chat')
    suspend fun sendMessage(
        @Body request: ChatRequest
    ): Response<String>

    companion object {
        // ✅ Points to YOUR Node.js backend, NOT Groq directly
        private const val BASE_URL = "http://10.0.2.2:3000/"

        fun create(): GroqApiService {
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GroqApiService::class.java)
        }
    }
}