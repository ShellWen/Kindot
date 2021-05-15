package top.goforce.kindot.ui.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import top.goforce.kindot.R
import top.goforce.kindot.base.BaseFragment
import top.goforce.kindot.databinding.MeFragmentBinding

class MeFragment : BaseFragment<MeFragmentBinding>(R.layout.me_fragment) {
    private val viewModel: MeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}