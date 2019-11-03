package com.example.livrofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.livrofinal.DragDrop.DragDropView
import com.example.livrofinal.Lista.telaListarLivros
import com.example.livrofinal.View.viewLivro
import com.example.livrofinal.ViewRecycle.ViewRecy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_recy.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun adicionar(v: View){
        val a =Intent(this, CadastrodeLivros::class.java)
        startActivity(a)
    }
    fun listarLivros(v: View){
        val b= Intent(this, telaListarLivros::class.java)
        startActivity(b)
    }
    fun viewLivros(v: View){
        val c = Intent(this, viewLivro::class.java)
        startActivity(c)
    }
    fun recycleLivros(v: View){
        val d = Intent(this, ViewRecy::class.java)
        startActivity(d)
    }
    fun gridview(v: View){
        val e = Intent (this, DragDropView::class.java)
        startActivity(e)
    }
}
