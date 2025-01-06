package com.kazmi.dev.project.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

object PermissionUtils {

    private const val READ_PERMISSION = Manifest.permission.READ_EXTERNAL_STORAGE
    private const val WRITE_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE
    private const val IMAGES_PERMISSION = Manifest.permission.READ_MEDIA_IMAGES
    private const val VIDEOS_PERMISSION = Manifest.permission.READ_MEDIA_VIDEO
    private const val AUDIO_PERMISSION = Manifest.permission.READ_MEDIA_AUDIO

    fun isReadPermissionAndroid12AndBelow(context: Context): Boolean{
        return ContextCompat.checkSelfPermission(context, READ_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    fun isWritePermissionAndroid12AndBelow(context: Context): Boolean{
        return ContextCompat.checkSelfPermission(context, WRITE_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun isImagesPermission(context: Context): Boolean{
        return ContextCompat.checkSelfPermission(context, IMAGES_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun isVideosPermission(context: Context): Boolean{
        return ContextCompat.checkSelfPermission(context, VIDEOS_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun isAudioPermission(context: Context): Boolean{
        return ContextCompat.checkSelfPermission(context, AUDIO_PERMISSION) == PackageManager.PERMISSION_GRANTED
    }


}