package com.example.livrofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import kotlinx.android.synthetic.main.activity_cadastrode_livros.*

class CadastrodeLivros : AppCompatActivity() {

    val db:AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro")
            .allowMainThreadQueries()
            .build()
    }
    companion object {
    var db: AppDataBase? = null
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrode_livros)
        //db = Room.databaseBuilder(this, AppDataBase::class.java,"bancoLivro").allowMainThreadQueries().build()
    }

    fun adiconarLivro(v : View){
        db.LivroDao().inserir(LivroModelo(tituloCad.toString(),autorCad.toString(),anoLivroCad.toString().toInt(),starCad.toString().toFloat()))
        Toast.makeText(this, "Adicionado com Sucesso !", Toast.LENGTH_SHORT).show()

    }
    fun cancelarAdicionar(v: View){
        finish()
    }
}
