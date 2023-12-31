package com.pedriito.audiodb.api_connect

data class track_model(
    val track: List<Track>
)

data class Track(
    val idTrack: String,
    val idAlbum: String,
    val idArtist: String,
    val idLyric: String,
    val idIMVDB: String,
    val strTrack: String,
    val strAlbum: String,
    val strArtist: String,
    val strArtistAlternate: String?,
    val intCD: String?,
    val intDuration: String,
    val strGenre: String,
    val strMood: String,
    val strStyle: String,
    val strTheme: String,
    val strDescriptionEN: String,
    val strDescriptionDE: String?,
    val strDescriptionFR: String?,
    val strDescriptionCN: String?,
    val strDescriptionIT: String?,
    val strDescriptionJP: String?,
    val strDescriptionRU: String?,
    val strDescriptionES: String?,
    val strDescriptionPT: String?,
    val strDescriptionSE: String?,
    val strDescriptionNL: String?,
    val strDescriptionHU: String?,
    val strDescriptionNO: String?,
    val strDescriptionIL: String?,
    val strDescriptionPL: String?,
    val strTrackThumb: String,
    val strTrack3DCase: String?,
    val strTrackLyrics: String,
    val strMusicVid: String,
    val strMusicVidDirector: String,
    val strMusicVidCompany: String,
    val strMusicVidScreen1: String,
    val strMusicVidScreen2: String,
    val strMusicVidScreen3: String,
    val intMusicVidViews: String,
    val intMusicVidLikes: String,
    val intMusicVidDislikes: String,
    val intMusicVidFavorites: String,
    val intMusicVidComments: String,
    val intTrackNumber: String,
    val intLoved: String,
    val intScore: String,
    val intScoreVotes: String,
    val intTotalListeners: String,
    val intTotalPlays: String,
    val strMusicBrainzID: String,
    val strMusicBrainzAlbumID: String,
    val strMusicBrainzArtistID: String,
    val strLocked: String
)

/*
* Return track details from artist/track name
searchtrack.php?s={Artist_Name}&t={Single_Name}
Example - theaudiodb.com/api/v1/json/{APIKEY}/searchtrack.php?s=coldplay&t=yellow*Patreon ONLY*

* */