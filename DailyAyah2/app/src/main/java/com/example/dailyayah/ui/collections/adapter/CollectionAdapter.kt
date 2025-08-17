package com.example.dailyayah.ui.collections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyayah.data.model.Favorite
import com.example.dailyayah.databinding.ItemFavoriteAyahBinding

class FavoriteAdapter(
    private val onItemClicked: (Favorite) -> Unit
) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var favorites: List<Favorite> = emptyList()

    fun submitList(newFavorites: List<Favorite>) {
        favorites = newFavorites
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemFavoriteAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favorites[position])
    }

    override fun getItemCount(): Int = favorites.size

    inner class FavoriteViewHolder(private val binding: ItemFavoriteAyahBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onItemClicked(favorites[adapterPosition])
                }
            }
        }

        fun bind(favorite: Favorite) {
            binding.tvFavoriteAyahText.text = favorite.reference
            binding.tvFavoriteAyahReference.text = "Ayah #${favorite.id}"
        }
    }
}
