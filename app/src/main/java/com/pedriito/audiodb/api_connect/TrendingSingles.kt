package com.pedriito.audiodb.api_connect

data class TrendingSinglesResponse(
    val trending: List<TrendingSingles>
)

data class TrendingSingles(
    val idTrend: String,
    val intChartPlace: String,
    val idArtist: String,
    val idAlbum: String,
    val idTrack: String,
    val strArtistMBID: String,
    val strAlbumMBID: String,
    val strTrackMBID: String,
    val strArtist: String,
    val strAlbum: String,
    val strTrack: String,
    val strArtistThumb: String?,
    val strAlbumThumb: String?,
    val strTrackThumb: String,
    val strCountry: String,
    val strType: String,
    val intWeek: String,
    val dateAdded: String
)
