package com.example.sicrediandroidtest.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    fun toMoneyPtBr(money: Double?): String =
        money?.let {
            val ptBr = Locale("pt", "BR")
            return NumberFormat.getCurrencyInstance(ptBr).format(money)
        } ?: "R$ 0,00"


    fun formatDate(time: Double): String {
        val date = Date(time.toLong())
        val format = SimpleDateFormat("dd/MM/yyyy")
        return format.format(date)
    }
}