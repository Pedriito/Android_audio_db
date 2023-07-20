package com.pedriito.audiodb.api_connect

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface apiInterfaceAlbum {

    @GET("trending.php?country=us&type=itunes&format=albums")
     fun getTendingAlbum() : Deferred<List<TrendingAlbumItem>>

    @GET("trending.php?country=us&type=itunes&format=singles")
    fun getTendingSigles() : Deferred<List<TrendingSingleItem>>

}