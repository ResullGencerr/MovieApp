package com.gencer.movieapp.Adapter.FilmListAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gencer.movieapp.Data.FilmListData.Data
import com.gencer.movieapp.Data.FilmListData.FilmListDataModel
import com.gencer.movieapp.Fragment.MainFragment.MainFragmentDirections
import com.gencer.movieapp.databinding.FilmListRowBinding
import com.gencer.movieapp.databinding.ItemViewPagerSlideBinding

class FilmListAdapter(private  val dataSet:List<Data>) :RecyclerView.Adapter<FilmListAdapter.FilmListViewHolder>() {

    class FilmListViewHolder(val binding: FilmListRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val binding = FilmListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
       val filmData = dataSet[position]
       Glide.with(holder.itemView.context)
           .load(filmData.poster.toString())
           .into(holder.binding.imageView3)
        holder.binding.textView12.text=filmData.title.toString()
        holder.binding.filmList.setOnClickListener {
            val action= MainFragmentDirections.actionMainFragmentToDetailsFragment(filmData.id)
            Navigation.findNavController(it).navigate(action)
        }

    }
}
