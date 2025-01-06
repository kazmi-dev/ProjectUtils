package com.kazmi.dev.project.utils

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.provider.MediaStore
import android.util.Log
import com.kazmi.dev.project.utils.DateTimeUtils.getFormatedDate
import com.kazmi.dev.project.utils.FileSizeUtils.getFormatedSize
import com.kazmi.dev.project.utils.enums.AudioSelectionArgs
import com.kazmi.dev.project.utils.enums.ImgSelectionArgs
import com.kazmi.dev.project.utils.enums.MediaSelectionArgs
import com.kazmi.dev.project.utils.enums.SortOrder
import com.kazmi.dev.project.utils.enums.VideoSelectionArgs
import com.kazmi.dev.project.utils.models.MediaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MediaStoreUtils {

    suspend fun getAllLocalImages(
        context: Context,
        selectionArgs: ImgSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): List<MediaModel> = withContext(Dispatchers.IO){
        val images = mutableListOf<MediaModel>()
        val imageCursor = getImageCursor(context, selectionArgs, sortOrder)
        imageCursor?.use {cursor->
            if (cursor.moveToFirst()){
                val idColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.ID)
                val pathColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.DATA)
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.DISPLAY_NAME)
                val dateModifiedColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.DATE_ADDED)
                val mimeTypeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.MIME_TYPE)
                val sizeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Image.SIZE)

                while (cursor.moveToNext()){
                    val id = cursor.getLong(idColumn)
                    val path = cursor.getString(pathColumn)
                    val name = cursor.getString(displayNameColumn)
                    val date = getFormatedDate(cursor.getLong(dateModifiedColumn))
                    val mimeType = cursor.getString(mimeTypeColumn)
                    val size = getFormatedSize(cursor.getLong(sizeColumn))

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    images.add(
                        MediaModel(
                            id = id,
                            path = path,
                            name = name,
                            date = date,
                            mimeType = mimeType,
                            size = size,
                            contentUri = contentUri
                        )
                    )
                    val media =   "Uri:$contentUri,\nPath:$path,\nFileName:$name,\nDate:$date,\ntype:$mimeType, \nsize:$size"
                    Log.d("93432847836784638437", "Media: $media")
                }

            }
        }
        return@withContext images
    }

    suspend fun getAllLocalVideos(
        context: Context,
        selectionArgs: VideoSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): List<MediaModel> = withContext(Dispatchers.IO){
        val videos = mutableListOf<MediaModel>()
        val videoCursor = getVideoCursor(context, selectionArgs, sortOrder)
        videoCursor?.use {cursor->
            Log.d("93432847836784638437", "Cursor not empty")
            if (cursor.moveToNext()){

                Log.d("93432847836784638437", "cursor first found")

                val idColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.ID)
                val pathColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.DATA)
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.DISPLAY_NAME)
                val dateModifiedColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.DATE_ADDED)
                val mimeTypeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.MIME_TYPE)
                val sizeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Video.SIZE)

                do {
                    Log.d("93432847836784638437", "getting videos")
                    val id = cursor.getLong(idColumn)
                    val path = cursor.getString(pathColumn)
                    val name = cursor.getString(displayNameColumn)
                    val date = getFormatedDate(cursor.getLong(dateModifiedColumn))
                    val mimeType = cursor.getString(mimeTypeColumn)
                    val size = getFormatedSize(cursor.getLong(sizeColumn))

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    videos.add(
                        MediaModel(
                            id = id,
                            path = path,
                            name = name,
                            date = date,
                            mimeType = mimeType,
                            size = size,
                            contentUri = contentUri
                        )
                    )
                    val media = "Uri:$contentUri,\nPath:$path,\nFileName:$name,\nDate:$date,\ntype:$mimeType, \nsize:$size"
                    Log.d("93432847836784638437", "Media: $media")
                }while (cursor.moveToNext())

            }else{
                Log.d("93432847836784638437", "cursor not move first, no videos found")
            }
        }
        return@withContext videos
    }

    suspend fun getAllLocalAudios(
        context: Context,
        selectionArgs: AudioSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): List<MediaModel> = withContext(Dispatchers.IO){
        val audios = mutableListOf<MediaModel>()
        val audioCursor = getAudioCursor(context, selectionArgs, sortOrder)
        audioCursor?.use {cursor->
            Log.d("93432847836784638437", "Cursor not empty")
            if (cursor.moveToNext()){

                Log.d("93432847836784638437", "cursor first found")

                val idColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.ID)
                val pathColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.DATA)
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.DISPLAY_NAME)
                val dateModifiedColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.DATE_ADDED)
                val mimeTypeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.MIME_TYPE)
                val sizeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.Audio.SIZE)

                do {
                    Log.d("93432847836784638437", "getting audios")
                    val id = cursor.getLong(idColumn)
                    val path = cursor.getString(pathColumn)
                    val name = cursor.getString(displayNameColumn)
                    val date = getFormatedDate(cursor.getLong(dateModifiedColumn))
                    val mimeType = cursor.getString(mimeTypeColumn)
                    val size = getFormatedSize(cursor.getLong(sizeColumn))

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        id
                    )
                    audios.add(
                        MediaModel(
                            id = id,
                            path = path,
                            name = name,
                            date = date,
                            mimeType = mimeType,
                            size = size,
                            contentUri = contentUri
                        )
                    )
                    val media = "Uri:$contentUri,\nPath:$path,\nFileName:$name,\nDate:$date,\ntype:$mimeType, \nsize:$size"
                    Log.d("93432847836784638437", "Media: $media")
                }while (cursor.moveToNext())

            }else{
                Log.d("93432847836784638437", "cursor not move first, no audios found")
            }
        }
        return@withContext audios
    }

    suspend fun getAllLocalMedia(
        context: Context,
        selectionArgs: MediaSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): List<MediaModel> = withContext(Dispatchers.IO){
        val media = mutableListOf<MediaModel>()
        val mediaCursor = getMediaFilesCursor(context, selectionArgs, sortOrder)
        mediaCursor?.use {cursor->
            Log.d("93432847836784638437", "Cursor not empty")
            if (cursor.moveToNext()){

                Log.d("93432847836784638437", "cursor first found")

                val idColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.ID)
                val pathColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.DATA)
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.DISPLAY_NAME)
                val dateModifiedColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.DATE_ADDED)
                val mimeTypeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.MIME_TYPE)
                val sizeColumn = cursor.getColumnIndexOrThrow(MediaStoreConstants.File.SIZE)

                do {
                    Log.d("93432847836784638437", "getting audios")
                    val id = cursor.getLong(idColumn)
                    val path = cursor.getString(pathColumn)
                    val name = cursor.getString(displayNameColumn)
                    val date = getFormatedDate(cursor.getLong(dateModifiedColumn))
                    val mimeType = cursor.getString(mimeTypeColumn)
                    val size = getFormatedSize(cursor.getLong(sizeColumn))

                    val contentUri = ContentUris.withAppendedId(
                        MediaStore.Files.getContentUri("external"),
                        id
                    )
                    media.add(
                        MediaModel(
                            id = id,
                            path = path,
                            name = name,
                            date = date,
                            mimeType = mimeType,
                            size = size,
                            contentUri = contentUri
                        )
                    )
                    val mediaTag = "Uri:$contentUri,\nPath:$path,\nFileName:$name,\nDate:$date,\ntype:$mimeType, \nsize:$size"
                    Log.d("93432847836784638437", "Media: $mediaTag")
                }while (cursor.moveToNext())

            }else{
                Log.d("93432847836784638437", "cursor not move first, no audios found")
            }
        }
        return@withContext media
    }


    private fun getImageCursor(
        context: Context,
        selectionArgs: ImgSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): Cursor?{
        val projection = arrayOf(
            MediaStoreConstants.Image.ID,
            MediaStoreConstants.Image.DATA,
            MediaStoreConstants.Image.DISPLAY_NAME,
            MediaStoreConstants.Image.DATE_ADDED,
            MediaStoreConstants.Image.MIME_TYPE,
            MediaStoreConstants.Image.SIZE
        )

        val collection =  MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val selection = selectionArgs?.let {
            "${MediaStoreConstants.Image.MIME_TYPE} LIKE ?"
        }
        val args = selectionArgs?.args
        val order = sortOrder?.let {
            "${MediaStoreConstants.Image.DATE_ADDED} ${sortOrder.order}"
        }

        return context.contentResolver.query(
            collection,
            projection,
            selection,
            args,
            order
        )
    }

    private fun getVideoCursor(
        context: Context,
        selectionArgs: VideoSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): Cursor?{
        val projection = arrayOf(
            MediaStoreConstants.Video.ID,
            MediaStoreConstants.Video.DATA,
            MediaStoreConstants.Video.DISPLAY_NAME,
            MediaStoreConstants.Video.DATE_ADDED,
            MediaStoreConstants.Video.MIME_TYPE,
            MediaStoreConstants.Video.SIZE
        )

        val collection =  MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val selection = selectionArgs?.let {
            "${MediaStoreConstants.Video.MIME_TYPE} = ?"
        }
        val args = selectionArgs?.args
        val order = sortOrder?.let {
            "${MediaStoreConstants.Video.DATE_ADDED} ${sortOrder.order}"
        }

        return context.contentResolver.query(
            collection,
            projection,
            selection,
            args,
            order
        )
    }

    private fun getAudioCursor(
        context: Context,
        selectionArgs: AudioSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): Cursor?{
        val projection = arrayOf(
            MediaStoreConstants.Audio.ID,
            MediaStoreConstants.Audio.DATA,
            MediaStoreConstants.Audio.DISPLAY_NAME,
            MediaStoreConstants.Audio.DATE_ADDED,
            MediaStoreConstants.Audio.MIME_TYPE,
            MediaStoreConstants.Audio.SIZE
        )

        val collection =  MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = selectionArgs?.let {
            "${MediaStoreConstants.Audio.MIME_TYPE} LIKE ?"
        }
        val args = selectionArgs?.args
        val order = sortOrder?.let {
            "${MediaStoreConstants.Audio.DATE_ADDED} ${sortOrder.order}"
        }

        return context.contentResolver.query(
            collection,
            projection,
            selection,
            args,
            order
        )
    }

    private fun getMediaFilesCursor(
        context: Context,
        selectionArgs: MediaSelectionArgs? = null,
        sortOrder: SortOrder? = null
    ): Cursor?{
        val projection = arrayOf(
            MediaStoreConstants.File.ID,
            MediaStoreConstants.File.DATA,
            MediaStoreConstants.File.DISPLAY_NAME,
            MediaStoreConstants.File.DATE_ADDED,
            MediaStoreConstants.File.MIME_TYPE,
            MediaStoreConstants.File.SIZE
        )

        val collection =   if (SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            MediaStore.Files.getContentUri("external")
        }
        val selection = selectionArgs?.let {
            "${MediaStoreConstants.File.MIME_TYPE} LIKE ?"
        }
        val args = selectionArgs?.args
        val order = sortOrder?.let {
            "${MediaStoreConstants.File.DATE_ADDED} ${sortOrder.order}"
        }

        return context.contentResolver.query(
            collection,
            projection,
            selection,
            args,
            order
        )
    }


}