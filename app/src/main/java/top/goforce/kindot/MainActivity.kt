package top.goforce.kindot

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import top.goforce.kindot.base.BaseActivity
import top.goforce.kindot.databinding.MainActivityBinding
import kotlin.concurrent.thread

class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setSupportActionBar(binding.toolbar)
        // TODO: 不单独开个线程会出现各种问题，寻求解决方案
        thread {
            runOnUiThread {
                val appBarConfiguration =
                    AppBarConfiguration(setOf(R.id.main_nav_home, R.id.main_nav_me))
                val navController = binding.navHostFragment.findNavController()
                binding.toolbar
                    .setupWithNavController(navController, appBarConfiguration)
                binding.bottomNav
                    .setupWithNavController(navController)

                navController.addOnDestinationChangedListener { _, _, _ ->
                    binding.appbar.setExpanded(true, true)
                }
            }
        }
    }
}