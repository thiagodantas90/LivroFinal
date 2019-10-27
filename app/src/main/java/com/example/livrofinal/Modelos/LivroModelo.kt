package com.example.livrofinal.Modelos

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "bancoLivro")
data class LivroModelo(
    var TituloLivro:String,
    var AutorLivro:String,
    var AnoLivro:Int,
    var EstrelasLivro:Float){

    @PrimaryKey(autoGenerate = true)
    var idLivro:Long = 0
    @Ignore
    var imagem:Bitmap? = null
}
