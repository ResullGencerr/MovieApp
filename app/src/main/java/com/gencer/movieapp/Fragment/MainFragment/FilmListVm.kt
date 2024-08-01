package com.gencer.movieapp.Fragment.MainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gencer.movieapp.Data.FilmListData.FilmListDataModel
import com.gencer.movieapp.Data.FilmListData.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmListVm:ViewModel() {
    val getFilmList=MutableLiveData<FilmListDataModel>()


   fun getFilm(){
       Network.service.getFilm(1).enqueue(object :Callback<FilmListDataModel>{
           override fun onResponse(
               call: Call<FilmListDataModel>,
               response: Response<FilmListDataModel>
           ) {
               if(response.isSuccessful && response.body()!=null){
                   getFilmList.postValue(response.body())
               }
           }

           override fun onFailure(call: Call<FilmListDataModel>, t: Throwable) {
                println("Hata ${t.message}")
           }

       })


   }

}