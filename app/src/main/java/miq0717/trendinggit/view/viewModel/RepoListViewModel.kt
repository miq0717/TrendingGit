package miq0717.trendinggit.view.viewModel

import androidx.lifecycle.MutableLiveData
import miq0717.trendinggit.model.Item
import miq0717.trendinggit.model.RepoRepository

/*Created by MiQ0717 on 08-Mar-2020.*/
class RepoListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoRepository.getInstance()
            .getRepoList { isSuccess, response ->
            dataLoading.value = false

            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}