package com.kazmi.dev.project.utils

import android.view.View
import androidx.annotation.ColorInt
import com.google.android.material.snackbar.Snackbar

object SnackBarUtils {

    private var snackBar: Snackbar? = null

    fun showSnackBar(
        view: View,
        message: String,
        @ColorInt textColor: Int? = null,
        @ColorInt backgroundColor: Int? = null,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionText: String? = null,
        action: ((View) -> Unit)? = null
    ){
        snackBar?.dismiss()
        snackBar = Snackbar.make(view, message, duration).apply {
            textColor?.let { setTextColor(it) }
            backgroundColor?.let { setActionTextColor(it) }
            actionText?.let { setAction(it, action) }
        }
        snackBar?.show()
    }

    fun dismissSnackBar(){
        snackBar?.dismiss()
    }


}