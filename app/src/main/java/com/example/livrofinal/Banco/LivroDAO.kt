package com.example.livrofinal.Banco

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.livrofinal.Modelos.LivroModelo

@Dao
interface LivroDAO{
    @Insert
    fun adicionar(LivroModelo:LivroModelo):Long

    @Query("SELECT * FROM `bancoLivro.sqlite`")
    fun listAll():List<LivroModelo>
}