package com.gencer.movieapp.Adapter.DetailsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gencer.movieapp.Adapter.CategoryAdapter.CategoryAdapter.CategoryViewHolder
import com.gencer.movieapp.Data.DetailsData.DetailsDatModel
import com.gencer.movieapp.databinding.CategoryRowBinding
import com.gencer.movieapp.databinding.DetailsGenresRowBinding

class DetailsGenresAdapter(private val dataSet:List<String>):RecyclerView.Adapter<DetailsGenresAdapter.DetailsGenresViewHolder>() {

    class DetailsGenresViewHolder(val binding: DetailsGenresRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsGenresViewHolder {
        val binding = DetailsGenresRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsGenresViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: DetailsGenresViewHolder, position: Int) {
    holder.binding.detailsRowGenres.text=dataSet[position].toString()
    }
}