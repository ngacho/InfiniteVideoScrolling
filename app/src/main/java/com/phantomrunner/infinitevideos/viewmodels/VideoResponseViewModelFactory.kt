package com.phantomrunner.infinitevideos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phantomrunner.infinitevideos.data.remote.VideoRepo

class VideoResponseViewModelFactory constructor(private val videoRepo: VideoRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(VideoResponseViewModel::class.java!!)) {
            VideoResponseViewModel(videoRepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}