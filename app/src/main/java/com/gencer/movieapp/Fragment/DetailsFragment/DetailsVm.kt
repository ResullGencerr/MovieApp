package com.gencer.movieapp.Fragment.DetailsFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gencer.movieapp.Data.DetailsData.DetailsDatModel
import com.gencer.movieapp.Data.DetailsData.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsVm:ViewModel() {
    val detailsData = MutableLiveData<DetailsDatModel>()


    fun getDetails(movieId:Int){
        Network.service.getDetails(movieId).enqueue(object :Callback<DetailsDatModel>{
            override fun onResponse(
                call: Call<DetailsDatModel>,
                response: Response<DetailsDatModel>
            ) {
               if(response.isSuccessful&&response.body()!=null){
                  detailsData.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<DetailsDatModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}