package com.csp.coroutines.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by kjt on 2019-07-24
 */
class ApiManager private constructor() {

    companion object {
        fun getInstance(): ApiManager {
            val instance: ApiManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                ApiManager()
            }
            return instance
        }
    }

    private lateinit var mRetrofit: Retrofit
    private val mApiService: ApiService by lazy {
        val client = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        mRetrofit = Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        mRetrofit.create(ApiService::class.java)
    }

    fun getApiService(): ApiService {
        return mApiService
    }

}