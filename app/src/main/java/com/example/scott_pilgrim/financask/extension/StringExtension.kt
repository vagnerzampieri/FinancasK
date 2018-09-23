package com.example.scott_pilgrim.financask.extension

private val defaultTruncate = 14

fun String.truncate() : String {
    if(this.length > defaultTruncate) {
        return "${this.substring(0, defaultTruncate)}..."
    }
    return this
}