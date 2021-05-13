package top.goforce.kindot.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import top.goforce.kindot.R
import top.goforce.kindot.base.BaseFragment
import top.goforce.kindot.databinding.MainFragmentBinding

class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}