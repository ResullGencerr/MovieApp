package com.gencer.movieapp.Fragment.MainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.gencer.movieapp.Adapter.CommingMoviesAdapter.ComingMoviesAdapter
import com.gencer.movieapp.Adapter.FilmListAdapter.FilmListAdapter
import com.gencer.movieapp.Adapter.SliderAdapter.SliderAdapter
import com.gencer.movieapp.Data.SliderImgData.SliderItem
import com.gencer.movieapp.R
import com.gencer.movieapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val filmViewModel : FilmListVm by viewModels()
    private  val comingViewModel :ComingMoviesVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideItems= listOf(
            SliderItem(R.drawable.wide),
            SliderItem(R.drawable.wide1),
            SliderItem(R.drawable.wide3)
        )
        val sliderAdapter=SliderAdapter(slideItems)
        binding.viewPager.adapter=sliderAdapter
        binding.viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        binding.bestMovieRcy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRcy.layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.comingMovieRcy.layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        filmViewModel.getFilm()
        comingViewModel.commingMovies()
        filmViewModel.getFilmList.observe(viewLifecycleOwner, Observer { filmData->
            if(filmData!=null) {
                binding.progressBar1.visibility = View.GONE
                val getFilmAdapter = FilmListAdapter(filmData.data)
                binding.bestMovieRcy.adapter = getFilmAdapter

            }
        })
        comingViewModel.commingMoviesData.observe(viewLifecycleOwner,Observer{ commingData->
            if(commingData!=null){
                binding.progressBar4.visibility=View.GONE
                val comingMoviesAdapter=ComingMoviesAdapter(commingData.data)
                binding.comingMovieRcy.adapter=comingMoviesAdapter
                commingData.data.forEach {
                    println("Film ${it.title}")
                }

            }
        })




    }

}