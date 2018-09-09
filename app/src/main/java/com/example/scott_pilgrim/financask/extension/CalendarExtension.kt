package com.example.scott_pilgrim.financask.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.dataFormatada(): String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}
