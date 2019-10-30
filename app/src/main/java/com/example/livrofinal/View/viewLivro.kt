package com.example.livrofinal.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.activity_view_livro.*

class viewLivro : AppCompatActivity() {
    var listaLivros: List<LivroModelo>? = null

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro.sqlite")
            .allowMainThreadQueries()
            .build()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listaLivros = db.LivroDao().listAll()
        setContentView(R.layout.activity_view_livro)
        listView.adapter = ViewLivroAdapter(this, listaLivros as List<LivroModelo>)
        listView.setOnItemClickListener{ViewLivroAdapter, view, i, l ->
            var livroSelecionado = listaLivros?.get(i)
        }

    }

}
