package com.kazmi.dev.project.utils.enums

enum class AudioSelectionArgs(val args: Array<String>) {
    // Audio
    AUDIO_MP3(arrayOf("audio/mpeg")),
    AUDIO_WAV(arrayOf("audio/x-wav")),
    AUDIO_FLAC(arrayOf("audio/flac")),
    AUDIO_AAC(arrayOf("audio/aac")),
}