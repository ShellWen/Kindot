package top.goforce.kindot

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import top.goforce.kindot.base.BaseActivity
import top.goforce.kindot.databinding.MainActivityBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(binding.toolbar)
    }
}