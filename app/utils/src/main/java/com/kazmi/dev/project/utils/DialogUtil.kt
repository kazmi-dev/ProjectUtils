package com.kazmi.dev.project.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.kazmi.dev.project.utils.databinding.DialogGenericLayoutBinding

class DialogUtil(
    context: Context,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit
) {

    private val layoutInflater = LayoutInflater.from(context)
    private val binding: ViewBinding = DialogGenericLayoutBinding.inflate(layoutInflater)

    private var dialog: AlertDialog? = null
    private var title: String = "Alert Dialog"
    private var description: String = "This is a simple alert dialog description"
    private var positiveBtnText: String = "Yes"
    private var negativeBtnText: String = "No"

    val dialogBuilder = AlertDialog.Builder(context).create()


}