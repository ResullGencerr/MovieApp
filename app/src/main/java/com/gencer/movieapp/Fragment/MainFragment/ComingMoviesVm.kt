package com.gencer.movieapp.Fragment.MainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gencer.movieapp.Data.CommingMoviesData.ComingMoviesDataModel
import com.gencer.movieapp.Data.CommingMoviesData.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ComingMoviesVm:ViewModel() {
    val commingMoviesData =MutableLiveData<ComingMoviesDataModel>()

    fun commingMovies(){
        Network.service.comingMovies(2).enqueue(object :Callback<ComingMoviesDataModel>{
            override fun onResponse(
                call: Call<ComingMoviesDataModel>,
                response: Response<ComingMoviesDataModel>
            ) {
                if(response.isSuccessful && response.body()!=null){
                    commingMoviesData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ComingMoviesDataModel>, t: Throwable) {
               println("Hata ${t.message}")
            }

        })
    }


}