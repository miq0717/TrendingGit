package miq0717.trendinggit.model

import miq0717.trendinggit.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*Created by MiQ0717 on 09-Mar-2020.*/
class RepoRepository {
    //GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {
        ApiClient.instance.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                onResult(false, null)
            }
        })
    }

    companion object {
        private var INSTANCE: RepoRepository? = null
        fun getInstance() = INSTANCE ?: RepoRepository().also {
            INSTANCE = it
        }
    }
}