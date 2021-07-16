package com.phantomrunner.infinitevideos.data.model

import com.google.gson.annotations.SerializedName

data class VideoSearchResponse (
    val page : Long,
    @SerializedName("per_page")
    val perPage : Long,
    @SerializedName("total_results")
    val totalResults : Long,
    val url : String,
    val videos : List<Video>
)