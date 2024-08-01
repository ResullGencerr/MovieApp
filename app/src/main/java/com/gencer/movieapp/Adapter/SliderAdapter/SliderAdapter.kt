package com.gencer.movieapp.Adapter.SliderAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gencer.movieapp.Data.SliderImgData.SliderItem
import com.gencer.movieapp.databinding.FragmentMainBinding
import com.gencer.movieapp.databinding.ItemViewPagerSlideBinding

class SliderAdapter(private val slideItems: List<SliderItem>):RecyclerView.Adapter<SliderAdapter.SliderViewHolder>()
{
    inner class SliderViewHolder(val binding: ItemViewPagerSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemViewPagerSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewHolder, position: Int) {
        val item = slideItems[position % slideItems.size] // Sonsuz kaydırma için mod alma
        holder.binding.imageView.setImageResource(item.imgSlider)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}