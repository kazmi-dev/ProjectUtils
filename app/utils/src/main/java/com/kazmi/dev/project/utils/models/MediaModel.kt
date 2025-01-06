package com.kazmi.dev.project.utils.models

import android.net.Uri

data class MediaModel(
    val id: Long,
    val path: String,
    val name: String,
    val date: String,
    val mimeType: String,
    val size: String,
    val contentUri: Uri
)
