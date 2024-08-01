package com.gencer.movieapp.Data.CommingMoviesData

import java.io.Serializable


data class ComingMoviesDataModel(val data: List<Data>,
                                 val metadata: Metadata):Serializable
data class Data(
    val country: String,
    val genres: List<String>,
    val id: Int,
    val images: List<String>,
    val imdb_rating: String,
    val poster: String,
    val title: String,
    val year: String
):Serializable

data class Metadata(  val current_page: String,
                      val page_count: Int,
                      val per_page: Int,
                      val total_count: Int):Serializable