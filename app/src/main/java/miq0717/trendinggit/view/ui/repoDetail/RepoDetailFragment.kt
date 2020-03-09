package miq0717.trendinggit.view.ui.repoDetail

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_repo_detail.*
import miq0717.trendinggit.R
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * A simple [Fragment] subclass.
 */

class RepoDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val url = RepoDetailFragmentArgs.fromBundle(arguments).url
        val url = arguments?.let { RepoDetailFragmentArgs.fromBundle(arguments).url }

        setupWebView()
        setClickListeners()

        repo_web_view.loadUrl(url)
    }

    private fun setClickListeners() {
        repo_back_button.onClick {
            repo_web_view.goBack()
        }

        repo_forward_button.onClick {
            repo_web_view.goForward()
        }

        repo_refresh_button.onClick {
            repo_web_view.reload()
        }
    }

    private fun setupWebView() {
        repo_web_view.setInitialScale(1)
        val webViewSettings = repo_web_view.settings
        webViewSettings.setAppCacheEnabled(false)
        webViewSettings.builtInZoomControls = true
        webViewSettings.displayZoomControls = false
        webViewSettings.javaScriptEnabled = true
        webViewSettings.useWideViewPort = true
        webViewSettings.domStorageEnabled = true

        repo_web_view.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                if (repo_back_button != null &&
                    repo_forward_button != null &&
                    repo_web_view != null && repo_progress_view != null
                ){
                    repo_back_button.isEnabled = repo_web_view.canGoBack()
                    repo_forward_button.isEnabled = repo_web_view.canGoForward()
                    repo_progress_view.visibility = GONE
                }
            }
        }
    }


}
