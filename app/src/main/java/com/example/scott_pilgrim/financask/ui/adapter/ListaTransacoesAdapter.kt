package com.example.scott_pilgrim.financask.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.scott_pilgrim.financask.R
import com.example.scott_pilgrim.financask.extension.dataFormatada
import com.example.scott_pilgrim.financask.extension.formataParaBrasileiro
import com.example.scott_pilgrim.financask.extension.truncate
import com.example.scott_pilgrim.financask.model.Tipo
import com.example.scott_pilgrim.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
        private val transacoes: List<Transacao>,
        private val context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = getItem(position)

        adicionaValor(transacao, viewCriada)
        adicionaIcone(transacao, viewCriada)
        adicionaCategoria(transacao, viewCriada)
        adicionaData(transacao, viewCriada)

        return viewCriada
    }

    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        viewCriada.transacao_valor.setTextColor(
                retornaCor(transacao.tipo)
        )
        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()
    }

    private fun adicionaIcone(transacao: Transacao, viewCriada: View) {
        viewCriada.transacao_icone.setBackgroundResource(retornaIcone(transacao.tipo))
    }

    private fun adicionaCategoria(transacao: Transacao, viewCriada: View) {
        viewCriada.transacao_categoria.text = transacao.categoria.truncate()
    }

    private fun adicionaData(transacao: Transacao, viewCriada: View) {
        viewCriada.transacao_data.text = transacao.data.dataFormatada()
    }

    private fun retornaCor(tipo: Tipo) : Int {
        return when (tipo) {
            Tipo.RECEITA -> ContextCompat.getColor(context, R.color.receita)
            Tipo.DESPESA -> ContextCompat.getColor(context, R.color.despesa)
        }
    }

    private fun retornaIcone(tipo: Tipo) : Int {
        return when(tipo) {
            Tipo.RECEITA -> R.drawable.icone_transacao_item_receita
            Tipo.DESPESA -> R.drawable.icone_transacao_item_despesa
        }
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return transacoes.size
    }
}