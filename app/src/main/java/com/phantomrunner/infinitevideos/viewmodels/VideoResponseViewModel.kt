package com.phantomrunner.infinitevideos.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.phantomrunner.infinitevideos.data.model.VideoSearchResponse
import com.phantomrunner.infinitevideos.data.remote.VideoRepo

class VideoResponseViewModel(private val videoRepo: VideoRepo) : ViewModel() {

    val getVideos = videoRepo.getVideos()
    fun videoResponse() : LiveData<VideoSearchResponse> = videoRepo.videoResponseLiveData

}