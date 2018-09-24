package com.example.scott_pilgrim.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import com.example.scott_pilgrim.financask.R
import com.example.scott_pilgrim.financask.extension.formataParaBrasileiro
import com.example.scott_pilgrim.financask.model.Resumo
import com.example.scott_pilgrim.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun atualiza() {
        adicionaReceita()
        adicionaDespesa()
        adicionaTotal()
    }

    private fun adicionaReceita() {
        val totalReceita = resumo.receita

        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            resumo_card_receita.text = totalReceita.formataParaBrasileiro()
        }
    }

    private fun adicionaDespesa() {
        val totalDespesa = resumo.despesa

        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text = totalDespesa.formataParaBrasileiro()
        }
    }

    private fun adicionaTotal() {
        val total = resumo.total

        with(view.resumo_card_total) {
            setTextColor(corPor(total))
            text = total.formataParaBrasileiro()
        }

    }

    private fun corPor(valor: BigDecimal) : Int {
        return if (valor >= BigDecimal.ZERO) {
            corReceita
        } else {
            corDespesa
        }
    }
}