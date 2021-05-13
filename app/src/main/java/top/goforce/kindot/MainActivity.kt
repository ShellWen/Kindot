package top.goforce.kindot

import android.os.Bundle
import top.goforce.kindot.base.BaseActivity
import top.goforce.kindot.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
    }
}