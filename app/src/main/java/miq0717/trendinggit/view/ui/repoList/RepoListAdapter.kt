package miq0717.trendinggit.view.ui.repoList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import miq0717.trendinggit.databinding.ViewRepoListItemBinding
import miq0717.trendinggit.model.Item
import miq0717.trendinggit.view.viewModel.RepoListViewModel

/*Created by MiQ0717 on 09-Mar-2020.*/
class RepoListAdapter(private val repoListViewModel: RepoListViewModel) :
    RecyclerView.Adapter<RepoListViewHolder>() {

    var repoList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListItemBinding.inflate(inflater, parent, false)
        return RepoListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setData(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}