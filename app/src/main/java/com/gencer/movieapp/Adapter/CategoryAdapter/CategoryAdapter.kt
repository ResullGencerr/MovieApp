package com.gencer.movieapp.Adapter.CategoryAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gencer.movieapp.Adapter.CommingMoviesAdapter.ComingMoviesAdapter.ComingMoviesViewHolder
import com.gencer.movieapp.Data.CategoryData.CategoryDataModel
import com.gencer.movieapp.databinding.CategoryRowBinding
import com.gencer.movieapp.databinding.ComingListRowBinding

class CategoryAdapter(private val dataSet:ArrayList<CategoryDataModel>):
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: CategoryRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
      var item = dataSet[position]
        holder.binding.textView14.text=item.name.toString()
    }
}