package com.gencer.movieapp.Data.DetailsData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsInterface {
    @GET("movies/{movie_id}")
    fun getDetails(@Path("movie_id") movie_id:Int):Call<DetailsDatModel>
}