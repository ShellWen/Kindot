package top.goforce.kindot.ui.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import top.goforce.kindot.R
import top.goforce.kindot.base.BaseFragment
import top.goforce.kindot.data.network.entity.LoginStatusEnum
import top.goforce.kindot.databinding.MeFragmentBinding

class MeFragment : BaseFragment<MeFragmentBinding>(R.layout.me_fragment) {
    private val viewModel: MeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun bindData() {
        binding.run {
            this.viewModel = this@MeFragment.viewModel
        }
    }

    private fun initViews() {
        binding.swipeRefresh.run {
            // 下拉刷新监听器设置为刷新登录状态
            setOnRefreshListener {
                viewModel.refreshLoginStatus()
            }
            // 观察登陆状态，为 REFRESHING 时更新下拉刷新组件展示刷新状态
            viewModel.loginStatus.observe(viewLifecycleOwner) {
                isRefreshing = it == LoginStatusEnum.REFRESHING
            }
        }

    }

}