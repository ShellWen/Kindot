package top.goforce.kindot.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    @Suppress("PropertyName")
    val TAG: String by lazy { this.javaClass.simpleName }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "$context -> onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$savedInstanceState -> onCreate()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "$savedInstanceState -> onActivityCreated()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach()")
    }
}