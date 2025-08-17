package com.example.dailyayah.ui.collections

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyayah.databinding.FragmentFavoritesBinding
import com.example.dailyayah.ui.collections.adapter.FavoriteAdapter


class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val favoritesViewModel: FavoritesViewModel by viewModels()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        favoriteAdapter = FavoriteAdapter { favorite ->
            // **UPDATED**: Pass the whole favorite object in the navigation action.
            val action = FavoritesFragmentDirections.actionFavoritesFragmentToAyahDetailDialogFragment(favorite)
            findNavController().navigate(action)
        }
        binding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
        }
    }

    private fun observeViewModel() {
        favoritesViewModel.favorites.observe(viewLifecycleOwner) { favoritesList ->
            favoriteAdapter.submitList(favoritesList)
        }

        favoritesViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // You can add a ProgressBar with id `progress_bar` to fragment_favorites.xml
            // binding.progressBar.isVisible = isLoading
            binding.rvFavorites.isVisible = !isLoading
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
