package top.goforce.kindot.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    @Suppress("PropertyName")
    val TAG: String by lazy { this.javaClass.simpleName }
}