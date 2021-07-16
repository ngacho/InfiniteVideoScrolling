package com.phantomrunner.infinitevideos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.phantomrunner.infinitevideos.R
import com.phantomrunner.infinitevideos.data.remote.VideoRepo
import com.phantomrunner.infinitevideos.viewmodels.VideoResponseViewModel
import com.phantomrunner.infinitevideos.viewmodels.VideoResponseViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoRepo = VideoRepo()
        val viewModel = ViewModelProvider(this, VideoResponseViewModelFactory(videoRepo)).get(
            VideoResponseViewModel::class.java
        )

        viewModel.videoResponse().observe(this, {
            val total = it.totalResults
            Log.i("Main Activity", "onCreate: $total")
        })
    }
}