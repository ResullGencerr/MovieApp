package com.gencer.movieapp.Data.FilmListData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmListInterface {
    @GET("movies")
    fun getFilm(@Query("page") page:Int):Call<FilmListDataModel>
}