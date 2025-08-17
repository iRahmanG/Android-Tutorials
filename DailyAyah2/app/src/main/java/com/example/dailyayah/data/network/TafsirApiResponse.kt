package com.example.dailyayah.data.model

/**
 * This data class represents the API response when fetching a single edition,
 * like a Tafsir. The key difference is that 'data' is a single object, not a list.
 */
data class TafsirApiResponse(
    val code: Int,
    val status: String,
    val data: AyahData // The 'data' field is now a single AyahData object
)
