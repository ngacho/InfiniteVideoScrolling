package com.phantomrunner.infinitevideos.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.phantomrunner.infinitevideos.BuildConfig
import com.phantomrunner.infinitevideos.data.model.VideoSearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class VideoRepo {

    var videoResponseLiveData : MutableLiveData<VideoSearchResponse> = MutableLiveData()

    var videoSearchService: VideoSearchService


    init {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient().newBuilder()
        httpClient.addInterceptor{ chain ->
            val original = chain.request()

            //add headers
            val requestBuilder = original.newBuilder().addHeader("Authorization", BuildConfig.api_key)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(loggingInterceptor)

        val client = httpClient.build()


        //initialize retrofit
        videoSearchService = Retrofit.Builder()
            .baseUrl(ServiceHelper.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideoSearchService::class.java)
    }

    fun getVideos(resultsPerPage : Long = 10){
        videoSearchService.searchVideos(resultsPerPage)
            .enqueue(object : Callback<VideoSearchResponse> {
                override fun onResponse(
                    call: Call<VideoSearchResponse>,
                    response: Response<VideoSearchResponse>
                ) {
                    videoResponseLiveData.postValue(response.body())
                    val video = videoResponseLiveData.value?.videos?.get(0)?.link
                    Log.i("Video Repo", "onResponse: link -> $video")
                }

                override fun onFailure(call: Call<VideoSearchResponse>, t: Throwable) {
                    Log.e("Video Repo", "onFailure: Failed!!")
                }

            })
    }


    /*
    * https://learntodroid.com/consuming-a-rest-api-using-retrofit2-with-the-mvvm-pattern-in-android/
    *
    * https://www.pexels.com/api/documentation/
    *
    * */








}