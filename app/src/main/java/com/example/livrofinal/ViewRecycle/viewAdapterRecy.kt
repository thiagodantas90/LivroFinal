package com.example.livrofinal.ViewRecycle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.activity_view_recy.*


class viewAdapterRecy (var c:Context, var listaLivros:List<LivroModelo>):RecyclerView.Adapter<viewHolderRecy>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderRecy {
        val view = LayoutInflater.from(c).inflate(R.layout.view_recycle, parent,false)
        return  viewHolderRecy(view)
    }

    override fun getItemCount(): Int {
        return listaLivros.size
    }

    override fun onBindViewHolder(holder: viewHolderRecy, position: Int) {
        val livroEscolhido = listaLivros[position]
        holder.tituloText.text = livroEscolhido.AutorLivro
        holder.autorText.text = livroEscolhido.AutorLivro
        holder.anoText.text = livroEscolhido.AnoLivro.toString()
        holder.estrelasText.text = livroEscolhido.EstrelasLivro.toString()
    }

}
