package com.gencer.movieapp.Adapter.CommingMoviesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gencer.movieapp.Data.CommingMoviesData.Data
import com.gencer.movieapp.Fragment.MainFragment.MainFragmentDirections
import com.gencer.movieapp.databinding.ComingListRowBinding

class ComingMoviesAdapter(private val dataSet:List<Data>):RecyclerView.Adapter<ComingMoviesAdapter.ComingMoviesViewHolder>() {

    class ComingMoviesViewHolder(val binding: ComingListRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingMoviesViewHolder {
        val binding = ComingListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComingMoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

    override fun onBindViewHolder(holder: ComingMoviesViewHolder, position: Int) {
        val filmData = dataSet[position]
        println("adaptöre gelen veri ${filmData.id}")
        Glide.with(holder.itemView.context)
            .load(filmData.poster.toString())
            .into(holder.binding.imageView4)
        holder.binding.textView13.text=filmData.title.toString()
        holder.binding.comingList.setOnClickListener {
            val action= MainFragmentDirections.actionMainFragmentToDetailsFragment(filmData.id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}