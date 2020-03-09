package miq0717.trendinggit.view.ui.repoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_repo_list.*
import miq0717.trendinggit.databinding.FragmentRepoListBinding
import miq0717.trendinggit.view.viewModel.RepoListViewModel
import org.jetbrains.anko.longToast

/**
 * A simple [Fragment] subclass.
 */
class RepoListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            viewModel = ViewModelProviders.of(this@RepoListFragment).get(RepoListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        // Inflate the layout for this fragment
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewModel?.fetchRepoList()

        setAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.viewModel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewModel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    private fun setAdapter() {
        val viewModel = viewDataBinding.viewModel

        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewModel!!)

            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter

        }
    }

}
