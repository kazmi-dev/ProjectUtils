package com.kazmi.dev.project.utils

import java.util.Locale
import kotlin.math.log10
import kotlin.math.pow

object FileSizeUtils {

    fun getFormatedSize(size: Long): String {
        if (size<=0) return "0B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (log10(size.toDouble()) / log10(1024.0)).toInt()
        return String.format(Locale.getDefault(),"%.1f %s", size / 1024.0.pow(digitGroups.toDouble()), units[digitGroups])
    }
}