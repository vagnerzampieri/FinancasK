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

        val transacoes = listOf(
                Transacao(BigDecimal(20.5),
                        "Comida",
                        tipo = Tipo.DESPESA),
                Transacao(BigDecimal(100.0),
                        "Economia",
                        tipo = Tipo.RECEITA)
        )

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }
}