package com.phantomrunner.infinitevideos.data.model

import com.google.gson.annotations.SerializedName

data class Video(
    val id : Long,
    val quality : String,
    @SerializedName("file_type")
    val fileType : String,
    val width : Long,
    val height : Long,
    val link : String
)