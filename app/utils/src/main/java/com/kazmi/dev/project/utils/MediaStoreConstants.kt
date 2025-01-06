package com.kazmi.dev.project.utils

import android.provider.MediaStore

object MediaStoreConstants {
    object Image{

        //Image Media
        const val ID = MediaStore.Images.Media._ID
        const val DATA = MediaStore.Images.Media.DATA
        const val RELATIVE_PATH = MediaStore.Images.Media.RELATIVE_PATH
        const val DISPLAY_NAME = MediaStore.Images.Media.DISPLAY_NAME
        const val DATE_ADDED = MediaStore.Images.Media.DATE_ADDED
        const val MIME_TYPE = MediaStore.Images.Media.MIME_TYPE
        const val SIZE = MediaStore.Images.Media.SIZE

    }

    object Video{
        //Video Media
        const val ID = MediaStore.Video.Media._ID
        const val DATA = MediaStore.Video.Media.DATA
        const val RELATIVE_PATH = MediaStore.Video.Media.RELATIVE_PATH
        const val DISPLAY_NAME = MediaStore.Video.Media.DISPLAY_NAME
        const val DATE_ADDED = MediaStore.Video.Media.DATE_ADDED
        const val MIME_TYPE = MediaStore.Video.Media.MIME_TYPE
        const val SIZE = MediaStore.Video.Media.SIZE
    }

    object Audio{
        //Audio Media
        const val ID = MediaStore.Audio.Media._ID
        const val DATA = MediaStore.Audio.Media.DATA
        const val RELATIVE_PATH = MediaStore.Audio.Media.RELATIVE_PATH
        const val DISPLAY_NAME = MediaStore.Audio.Media.DISPLAY_NAME
        const val DATE_ADDED = MediaStore.Audio.Media.DATE_ADDED
        const val MIME_TYPE = MediaStore.Audio.Media.MIME_TYPE
        const val SIZE = MediaStore.Audio.Media.SIZE
    }

    object File{
        //Audio Media
        const val ID = MediaStore.Files.FileColumns._ID
        const val DATA = MediaStore.Files.FileColumns.DATA
        const val RELATIVE_PATH = MediaStore.Files.FileColumns.RELATIVE_PATH
        const val DISPLAY_NAME = MediaStore.Files.FileColumns.DISPLAY_NAME
        const val DATE_ADDED = MediaStore.Files.FileColumns.DATE_ADDED
        const val MIME_TYPE = MediaStore.Files.FileColumns.MIME_TYPE
        const val SIZE = MediaStore.Files.FileColumns.SIZE
    }

}