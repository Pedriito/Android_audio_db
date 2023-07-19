package com.pedriito.audiodb.api_connect

data class album_model(
    val album: List<Album>
)

data class Album(
    val strAlbum: String,
    val intYearReleased: String
)
