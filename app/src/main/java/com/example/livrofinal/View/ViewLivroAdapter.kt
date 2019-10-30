package com.example.livrofinal.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R

class ViewLivroAdapter (var c: Context, var Livro:List<LivroModelo>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:livroHolder
        var view:View

        if(convertView == null){
            view = LayoutInflater.from(c).inflate(R.layout.viewmodel, parent,false)
            holder = livroHolder(view)
            view.tag = holder

        }else{
            view = convertView
            holder = convertView.tag as livroHolder
        }

        val livroAtual = Livro[position]

        holder.titulotext.text = livroAtual.TituloLivro
        holder.autoText.text = livroAtual.AutorLivro
        holder.anoText.text = livroAtual.AnoLivro.toString()
        holder.estrelasRating.rating = livroAtual.EstrelasLivro

        return view

    }

    override fun getItem(position: Int): Any {
        return  Livro.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return Livro.size
    }

}