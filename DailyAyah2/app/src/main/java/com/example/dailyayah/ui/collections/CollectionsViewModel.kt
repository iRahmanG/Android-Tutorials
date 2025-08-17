package com.example.dailyayah.ui.collections


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dailyayah.data.model.Favorite
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.toObject

class FavoritesViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private val _favorites = MutableLiveData<List<Favorite>>()
    val favorites: LiveData<List<Favorite>> = _favorites

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private var favoritesListener: ListenerRegistration? = null

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        _isLoading.value = true
        val userId = auth.currentUser?.uid
        if (userId == null) {
            Log.d("FavoritesViewModel", "No user is signed in. Cannot load favorites.")
            _isLoading.value = false
            return
        }

        Log.d("FavoritesViewModel", "Loading favorites for user: $userId")
        val favoritesCollection = db.collection("users").document(userId).collection("favorites")

        favoritesListener = favoritesCollection.addSnapshotListener { snapshots, error ->
            if (error != null) {
                Log.e("FavoritesViewModel", "Listen failed.", error)
                _isLoading.value = false
                return@addSnapshotListener
            }

            if (snapshots == null) {
                Log.d("FavoritesViewModel", "Snapshot is null.")
                _isLoading.value = false
                return@addSnapshotListener
            }

            Log.d("FavoritesViewModel", "Received ${snapshots.size()} documents.")

            val favoriteList = snapshots.documents.mapNotNull { doc ->
                // Log each document's data before trying to convert it
                Log.d("FavoritesViewModel", "Document data: ${doc.data}")
                // The toObject<>() method automatically maps fields to your data class properties
                doc.toObject<Favorite>()?.copy(id = doc.id)
            }

            Log.d("FavoritesViewModel", "Mapped to ${favoriteList.size} Favorite objects.")
            _favorites.value = favoriteList
            _isLoading.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Important: Remove the listener when the ViewModel is destroyed to prevent memory leaks
        favoritesListener?.remove()
    }
}
