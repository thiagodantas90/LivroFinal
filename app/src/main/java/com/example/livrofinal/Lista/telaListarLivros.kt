package com.example.livrofinal.Lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.activity_tela_listar_livros.*

class telaListarLivros : AppCompatActivity() {

    var todos: List<LivroModelo>? = null
    var tamanho:Int = 0
    var direcionar:Int=0
    companion object {
        var db: AppDataBase? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_listar_livros)
        db = Room.databaseBuilder(this, AppDataBase::class.java,"bancoLivro.sqlite").allowMainThreadQueries().build()
        if(db!= null){
            todos =  db!!.LivroDao().listAll()
        }
        if(todos!!.size>0){
            tamanho = todos!!.size
            verLivro(direcionar)
        }
    }

    fun proximo(v: View){
        if(tamanho>1 && direcionar<tamanho-1){
            direcionar++
            verLivro(direcionar)
        }
    }

    fun anterior(v: View){
        if(direcionar>0){
            direcionar--
            verLivro(direcionar)
        }
    }

    fun verLivro(n:Int){
        tituloLista.text = todos?.get(n)?.TituloLivro.toString()
        autorLista.text = todos?.get(n)?.AutorLivro.toString()
        anoLista.text = todos?.get(n)?.AnoLivro.toString()
        starLista.rating = todos?.get(n)?.EstrelasLivro!!.toFloat()

    }
}
