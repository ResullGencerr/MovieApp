package com.gencer.movieapp.Fragment.MainFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gencer.movieapp.Data.CategoryData.CategoryDataModel
import com.gencer.movieapp.Data.CategoryData.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryVm:ViewModel() {
    var categoryData=MutableLiveData<ArrayList<CategoryDataModel>>()

    fun getCategory(){
        Network.service.getCategory().enqueue(object : Callback<ArrayList<CategoryDataModel>>{
            override fun onResponse(
                call: Call<ArrayList<CategoryDataModel>>,
                response: Response<ArrayList<CategoryDataModel>>
            ) {
               if(response.isSuccessful && response.body()!=null){
                  categoryData.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<ArrayList<CategoryDataModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}