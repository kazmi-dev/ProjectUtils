package com.kazmi.dev.project.utils.enums

enum class VideoSelectionArgs(val args: Array<String>) {
    // Videos
    VIDEO_MP4(arrayOf("video/mp4")),
    VIDEO_AVI(arrayOf("video/avi")),
    VIDEO_MKV(arrayOf("video/x-matroska")),
    VIDEO_MOV(arrayOf("video/quicktime")),
}