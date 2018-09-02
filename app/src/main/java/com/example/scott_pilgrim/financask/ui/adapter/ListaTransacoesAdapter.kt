package com.example.scott_pilgrim.financask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.scott_pilgrim.financask.R
import com.example.scott_pilgrim.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesAdapter(transacoes: List<Transacao>,
                             context: Context) : BaseAdapter() {

    private val transacoes = transacoes
    private val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = getItem(position)

        viewCriada.transacao_valor.setText(transacao.getValor().toString())
        viewCriada.transacao_categoria.setText(transacao.getCategoria())
        viewCriada.transacao_data.setText(dataFormatada(transacao.getData()))

        return viewCriada
    }

//     TODO this is not be here
    private fun dataFormatada(data: Calendar): String {
        val formatoBrasileiro = "dd/MM/yyyy"
        val format = SimpleDateFormat(formatoBrasileiro)
        return format.format(data.time)
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