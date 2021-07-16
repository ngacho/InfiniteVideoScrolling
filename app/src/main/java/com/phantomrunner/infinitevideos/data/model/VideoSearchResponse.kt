package com.phantomrunner.infinitevideos.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VideoSearchResponse (
    val page : Long,
    @SerializedName("per_page")
    @Expose
    val perPage : Long,
    @SerializedName("total_results")
    @Expose
    val totalResults : Long,
    val url : String,
    val videos : List<Video>
)