package com.gencer.movieapp.Fragment.DetailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gencer.movieapp.Adapter.CategoryAdapter.CategoryAdapter
import com.gencer.movieapp.Adapter.DetailsAdapter.DetailsGenresAdapter
import com.gencer.movieapp.Adapter.DetailsAdapter.DetailsImgAdapter
import com.gencer.movieapp.R
import com.gencer.movieapp.databinding.FragmentDetailsBinding
import com.gencer.movieapp.databinding.FragmentLoginBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private  val viewModel : DetailsVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.genreView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.imagesRcyler.layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val movieId=args.movieId
        viewModel.getDetails(movieId)
        viewModel.detailsData.observe(viewLifecycleOwner, Observer { data->
            if(data!=null){
                val dataGenres=data.genres
                val time=data.runtime.split(" ")[0]
                binding.progressDetailBar.visibility=View.GONE
                binding.movieName.text=data.title.toString()
                binding.summeryMovie.text=data.plot.toString()
                binding.movieStar.text=data.imdb_rating.toString()
                binding.movieTime.text="$time dakika"
                binding.actor.text=data.actors.toString()
                Glide.with(view.context).load(data.poster.toString()).into(binding.movieDetailsMage)
               val genresAdapter=DetailsGenresAdapter(dataGenres)
                binding.genreView.adapter=genresAdapter
                val imageAdapter=DetailsImgAdapter(data.images)
                binding.imagesRcyler.adapter=imageAdapter
            }
        })
        binding.backBtn.setOnClickListener {
            val action=DetailsFragmentDirections.actionDetailsFragmentToMainFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }

}