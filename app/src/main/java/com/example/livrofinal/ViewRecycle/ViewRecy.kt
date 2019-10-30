package com.example.livrofinal.ViewRecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.activity_view_recy.*

class ViewRecy : AppCompatActivity() {
    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recy)
        var adapter = viewAdapterRecy(this, db.LivroDao().listAll())
        viewRecycleHolder.adapter = adapter
        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        viewRecycleHolder.layoutManager = layout
    }
}
