package com.example.scott_pilgrim.financask.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.scott_pilgrim.financask.R
import com.example.scott_pilgrim.financask.extension.dataFormatada
import com.example.scott_pilgrim.financask.model.Tipo
import com.example.scott_pilgrim.financask.model.Transacao
import com.example.scott_pilgrim.financask.ui.ResumoView
import com.example.scott_pilgrim.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = transacoesExemplos()

        configurarResumo(transacoes)
        configurarLista(transacoes)

        lista_transacoes_adiciona_receita.setOnClickListener {
            val view : View = window.decorView
            val viewCriada = LayoutInflater.from(this)
                    .inflate(R.layout.form_transacao, view as ViewGroup, false)

            val year = 2018
            val month = 8
            val dayOfMonth = 25

            val today = Calendar.getInstance()

            viewCriada.form_transacao_data.setOnClickListener {
                DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                            val dataSelecionada = Calendar.getInstance()
                            dataSelecionada.set(year, month, dayOfMonth)
                            viewCriada.form_transacao_data
                                .setText(dataSelecionada.dataFormatada())
                        }, year, month, dayOfMonth)
                .show()
            }

            val adapter = ArrayAdapter
                    .createFromResource(this,
                            R.array.categorias_de_receita,
                            android.R.layout.simple_spinner_dropdown_item)

            viewCriada.form_transacao_categoria.adapter = adapter

            AlertDialog.Builder(this)
                    .setTitle(R.string.adiciona_receita)
                    .setView(viewCriada)
                    .setPositiveButton("Adicionar", null)
                    .setNegativeButton("Cancelar", null)
                    .show()
        }
    }

    fun configurarResumo(transacoes: List<Transacao>) {
        val resumoView = ResumoView(this, window.decorView, transacoes)

        resumoView.atualiza()
    }

    private fun configurarLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }


    private fun transacoesExemplos(): List<Transacao> {
        return listOf(
                Transacao(valor = BigDecimal(20.5),
                        categoria = "Comida",
                        tipo = Tipo.DESPESA),
                Transacao(valor = BigDecimal(100.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(valor = BigDecimal(30.0),
                        categoria = "Filme",
                        tipo = Tipo.DESPESA),
                Transacao(valor = BigDecimal(200.5),
                        categoria = "Comida",
                        tipo = Tipo.DESPESA),
                Transacao(valor = BigDecimal(100.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(valor = BigDecimal(30.0),
                        categoria = "Filme",
                        tipo = Tipo.DESPESA)
        )
    }
}

