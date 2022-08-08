package com.example.booksapp.retrofit

import com.example.booksapp.model.BooksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("?format=json")
    suspend fun getAllBooks() : Response<BooksResponse>

    @GET("?format=json")
    suspend fun getSingleBook(@Query("id") id: Int): Response<BooksResponse>
}

//ggoge.com/?id=5