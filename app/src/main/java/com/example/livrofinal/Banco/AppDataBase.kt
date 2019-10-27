package com.example.livrofinal.Banco

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livrofinal.Modelos.LivroModelo

@Database(entities = arrayOf(LivroModelo::class), version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun LivroDao():LivroDAO
}