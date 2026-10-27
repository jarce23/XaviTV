package com.minuevaapp.tv.data

import retrofit2.http.GET
import retrofit2.http.Query

interface XtreamApi {
    @GET("player_api.php")
    suspend fun login(@Query("username") u: String, @Query("password") p: String): LoginResponse

    @GET("player_api.php?action=get_live_categories")
    suspend fun liveCategories(@Query("username") u: String, @Query("password") p: String): List<Category>

    @GET("player_api.php?action=get_live_streams")
    suspend fun liveStreams(@Query("username") u: String, @Query("password") p: String): List<LiveStream>

    @GET("player_api.php?action=get_vod_categories")
    suspend fun vodCategories(@Query("username") u: String, @Query("password") p: String): List<Category>

    @GET("player_api.php?action=get_vod_streams")
    suspend fun vodStreams(@Query("username") u: String, @Query("password") p: String): List<VodStream>

    @GET("player_api.php?action=get_vod_info")
    suspend fun vodInfo(
        @Query("username") u: String, @Query("password") p: String, @Query("vod_id") id: String,
    ): VodInfoResponse

    @GET("player_api.php?action=get_series_categories")
    suspend fun seriesCategories(@Query("username") u: String, @Query("password") p: String): List<Category>

    @GET("player_api.php?action=get_series")
    suspend fun series(@Query("username") u: String, @Query("password") p: String): List<Series>

    @GET("player_api.php?action=get_series_info")
    suspend fun seriesInfo(
        @Query("username") u: String, @Query("password") p: String, @Query("series_id") id: String,
    ): SeriesInfoResponse

    @GET("player_api.php?action=get_short_epg")
    suspend fun shortEpg(
        @Query("username") u: String, @Query("password") p: String, @Query("stream_id") id: String,
    ): EpgResponse
}
