package com.example.apicall

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Base_Url = "https://gorest.co.in/"


interface ApiInterface{

    @GET("public/v1/users?page=1")
    fun getdetail(@Query("page")page:Int) : Call<Detail>

}

object ApiService{
    val apiInstance: ApiInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        apiInstance = retrofit.create(ApiInterface::class.java)
    }
}
