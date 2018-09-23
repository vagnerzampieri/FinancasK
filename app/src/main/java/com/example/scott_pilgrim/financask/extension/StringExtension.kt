package com.example.scott_pilgrim.financask.extension

private const val DEFAULT_TRUNCATE = 14

fun String.truncate() : String {
    if(this.length > DEFAULT_TRUNCATE) {
        return "${this.substring(0, DEFAULT_TRUNCATE)}..."
    }
    return this
}