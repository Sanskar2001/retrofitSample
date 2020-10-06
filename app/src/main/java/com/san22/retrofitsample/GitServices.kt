package com.san22.retrofitsample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitServices
{
    @GET("users")
    suspend fun getusers():Response<List<User>>
    @GET("users/{id}")
    suspend fun getuserbyid(@Path("id")id:String):Response<User>
    @GET("search/users")
    suspend fun searchUsers(@Query("q")query:String):Response<List<User>>

}