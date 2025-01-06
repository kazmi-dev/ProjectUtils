package com.kazmi.dev.project.utils.enums

enum class MediaSelectionArgs(val args: Array<String>) {

    // Documents
    DOCUMENT_PDF(arrayOf("application/pdf")),
    DOCUMENT_DOC(arrayOf("application/msword")),
    DOCUMENT_DOCX(arrayOf("application/vnd.openxmlformats-officedocument.wordprocessingml.document")),
    DOCUMENT_XLS(arrayOf("application/vnd.ms-excel")),
    DOCUMENT_XLSX(arrayOf("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")),
    DOCUMENT_PPT(arrayOf("application/vnd.ms-powerpoint")),
    DOCUMENT_PPTX(arrayOf("application/vnd.openxmlformats-officedocument.presentationml.presentation")),

    // Text files
    TEXT_PLAIN(arrayOf("text/plain")),
    TEXT_HTML(arrayOf("text/html")),
    TEXT_CSV(arrayOf("text/csv")),

    // Archives
    ARCHIVE_ZIP(arrayOf("application/zip")),
    ARCHIVE_RAR(arrayOf("application/vnd.rar")),
    ARCHIVE_7Z(arrayOf("application/x-7z-compressed")),
    ARCHIVE_TAR(arrayOf("application/x-tar")),
    ARCHIVE_GZ(arrayOf("application/gzip")),
}
