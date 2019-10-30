package com.example.livrofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livrofinal.Lista.telaListarLivros
import com.example.livrofinal.View.viewLivro
import com.example.livrofinal.ViewRecycle.ViewRecy
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_recy.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnTelaCadastro.setOnClickListener(){
            val a =Intent(this, CadastrodeLivros::class.java)
            startActivity(a)
        }
        btnListar.setOnClickListener(){
            val b= Intent(this, telaListarLivros::class.java)
            startActivity(b)
        }
        btnViewList.setOnClickListener(){
            val c = Intent(this, viewLivro::class.java)
            startActivity(c)
        }
        btnViewRecy.setOnClickListener(){
            val d = Intent(this, ViewRecy::class.java)
            startActivity(d)
        }

    }
}
