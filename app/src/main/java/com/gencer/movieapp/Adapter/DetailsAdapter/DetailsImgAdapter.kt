package com.gencer.movieapp.Adapter.DetailsAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gencer.movieapp.Adapter.CategoryAdapter.CategoryAdapter.CategoryViewHolder
import com.gencer.movieapp.databinding.CategoryRowBinding
import com.gencer.movieapp.databinding.DetailsImgRowBinding

class DetailsImgAdapter(val dataSet:List<String>):RecyclerView.Adapter<DetailsImgAdapter.DetailsImgViewHolder>(){
    class DetailsImgViewHolder(val binding: DetailsImgRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsImgViewHolder {
        val binding = DetailsImgRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsImgViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return  dataSet.size
    }

    override fun onBindViewHolder(holder: DetailsImgViewHolder, position: Int) {
        val image=dataSet[position]
        Glide.with(holder.itemView.context).load(image.toString()).into(holder.binding.imageView7)
    }
}