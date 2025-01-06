package com.kazmi.dev.project.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.log10
import kotlin.math.pow

object DateTimeUtils {

    fun getFormatedDate(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val formatter = SimpleDateFormat("dd, MM/yyyy", Locale.getDefault())
        return formatter.format(date)
    }

}