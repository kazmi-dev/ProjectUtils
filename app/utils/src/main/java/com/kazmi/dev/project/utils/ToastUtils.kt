package com.kazmi.dev.project.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

object ToastUtils {

    @Volatile
    private var toast: Toast? = null

    private fun showToast(context: Context, message: String, duration: Int) {
        synchronized(this) {
            toast?.cancel()
            toast = Toast.makeText(context, message, duration)
            toast?.show()
        }
    }

    //For custom view toasts
    fun showCustomToast(context: Context, view: View, duration: Int) {
        synchronized(this) {
            toast?.cancel()
            toast = Toast(context).apply {
                this.view = view
                this.duration = duration
            }
            toast?.show()
        }
    }

    //Fragment Specific
    fun Fragment.shortToast(message: String) {
        showToast(requireContext(), message, Toast.LENGTH_SHORT)
    }

    fun Fragment.longToast(message: String) {
        showToast(requireContext(), message, Toast.LENGTH_LONG)
    }

    //Activity Specific
    fun Activity.shortToast(message: String) {
        showToast(this, message, Toast.LENGTH_SHORT)
    }

    fun Activity.longToast(message: String) {
        showToast(this, message, Toast.LENGTH_LONG)
    }


}