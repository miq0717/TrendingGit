package miq0717.trendinggit.model.api

import miq0717.trendinggit.model.GitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/*Created by MiQ0717 on 09-Mar-2020.*/
interface ApiService {
    @GET("search/repositories")
    fun getRepo(
        @Query("q") search: String = "trending",
        @Query("sort") sort: String = "start"
    ): Call<GitResponse>
}