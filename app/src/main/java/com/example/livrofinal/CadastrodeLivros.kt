package com.example.livrofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.*
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import kotlinx.android.synthetic.main.activity_cadastrode_livros.*

class CadastrodeLivros : AppCompatActivity() {


    val db:AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro.sqlite")
            .allowMainThreadQueries()
            .build()
    }

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrode_livros)
    }

    fun adiconarLivro(v : View){
       // db.LivroDao().adicionar(LivroModelo("thiago","dantas","1990","45"))
        db.LivroDao().adicionar(
            LivroModelo(
                tituloCad.editableText.toString(),
                autorCad.editableText.toString(),
                anoLivroCad.editableText.toString(),
                starCad.rating.toString()
                //starCad.rating.toString()

            ))

        Toast.makeText(this, "Adicionado com Sucesso !", Toast.LENGTH_SHORT).show()
    }
    fun cancelarAdicionar(v: View){
        finish()
    }
}
