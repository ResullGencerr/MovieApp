package com.gencer.movieapp.Data.CommingMoviesData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ComingMoviesInterface {
    @GET("movies")
    fun comingMovies(@Query("page") page:Int):Call<ComingMoviesDataModel>
}