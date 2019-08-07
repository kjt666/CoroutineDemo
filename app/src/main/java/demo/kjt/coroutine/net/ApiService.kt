package com.csp.coroutines.net

import com.csp.coroutines.NewsBean
import demo.kjt.coroutine.net.UrlConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kjt on 2019-07-24
 */
interface ApiService {

    @GET(UrlConstant.getNews)
    fun getNews(
        @Query("type") type: String,
        @Query("key") key: String
    ): Deferred<NewsBean>

    fun login(
        @Query("phone") phone: String,
        @Query("pwd") pwd: String
    ):Deferred<String>

    fun getToken(
        @Query("userId") userId: String
    ):Deferred<String>
}