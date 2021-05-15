package top.goforce.kindot.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import top.goforce.kindot.R
import top.goforce.kindot.base.BaseFragment
import top.goforce.kindot.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}