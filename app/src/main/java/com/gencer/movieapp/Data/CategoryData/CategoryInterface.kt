package com.gencer.movieapp.Data.CategoryData

import retrofit2.Call
import retrofit2.http.GET

interface CategoryInterface {
    @GET("genres")
    fun getCategory():Call<ArrayList<CategoryDataModel>>
}