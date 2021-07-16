package com.phantomrunner.infinitevideos.data.remote

import com.phantomrunner.infinitevideos.data.model.VideoSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoSearchService {
    @GET("/videos/popular")
    fun searchVideos(
        @Query("per_page") perPage : Long
    ) : Call<VideoSearchResponse>
}