package miq0717.trendinggit.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*Created by MiQ0717 on 08-Mar-2020.*/
open class BaseViewModel : ViewModel() {
    val empty = MutableLiveData<Boolean>().apply { value = false }

    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()
}