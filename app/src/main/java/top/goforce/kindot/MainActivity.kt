package top.goforce.kindot

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import top.goforce.kindot.base.BaseActivity
import top.goforce.kindot.databinding.MainActivityBinding
import top.goforce.kindot.ui.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(binding.toolbar)
    }
}