package com.example.zimozitask.data.network

import com.example.zimozitask.data.model.Person
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface Api {
    @GET("Demonuts/JsonTest/Tennis/json_parsing.php")
    fun getEverything() : Call<Person>
}
val httpLogging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val client = OkHttpClient().newBuilder()
    .addInterceptor(httpLogging)
    .build()

val retrofit=Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://demonuts.com/")
    .client(client)
    .build()

val service= retrofit.create(Api::class.java)