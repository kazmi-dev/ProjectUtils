package com.kazmi.dev.project.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

object KeyboardUtils {


    private fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun showKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // For Android 9 and above, you need to use specific behavior to show the keyboard in some cases.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        } else {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }
    }

    //Fragment Specific
    fun Fragment.showKeyboard(view: View){
        showKeyboard(requireContext(), view)
    }
    fun Fragment.hideKeyboard(view: View){
        hideKeyboard(requireContext(), view)
    }

    //Activity Specific
    fun Activity.showKeyboard(view: View){
        showKeyboard(this, view)
    }
    fun Activity.hideKeyboard(view: View){
        hideKeyboard(this, view)
    }


}