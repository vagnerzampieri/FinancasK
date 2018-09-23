package com.example.scott_pilgrim.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.scott_pilgrim.financask.R
import com.example.scott_pilgrim.financask.model.Tipo
import com.example.scott_pilgrim.financask.model.Transacao
import com.example.scott_pilgrim.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = transacoesExemplos()

        lista_transacoes_listview.adapter = configuraTransacoes(transacoes)
    }

    fun configuraTransacoes(transacoes: List<Transacao>) =
            ListaTransacoesAdapter(transacoes, this)

    fun transacoesExemplos(): List<Transacao> {
        return listOf(
                Transacao(valor = BigDecimal(20.5),
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