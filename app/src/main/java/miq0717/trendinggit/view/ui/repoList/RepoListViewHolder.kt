package miq0717.trendinggit.view.ui.repoList

import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*
import miq0717.trendinggit.BR
import miq0717.trendinggit.R
import miq0717.trendinggit.model.Item
import miq0717.trendinggit.view.viewModel.RepoListViewModel
import org.jetbrains.anko.sdk27.coroutines.onClick

/*Created by MiQ0717 on 09-Mar-2020.*/
class RepoListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val repoListViewModel: RepoListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar

    fun setData(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.owner.avatar_url).into(avatarImage)

        itemView.onClick {
            val bundle = bundleOf("url" to itemData.html_url)
            itemView.findNavController()
                .navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}