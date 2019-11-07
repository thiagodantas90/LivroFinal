package com.example.livrofinal.DragDrop

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import java.util.*
import kotlin.collections.ArrayList

class AdapterDragDrop (var c:Context, var livro:MutableList<LivroModelo>): RecyclerView.Adapter<ViewHolderDragDrop>(){

    private val PENDING_REMOVAL_TIMEOUT:Long = 3000
    var itemsPendingRemoval = ArrayList<LivroModelo>()

    //private val handler = Handler()
    private val handler = Handler()

    var pendingRunnables:HashMap<LivroModelo, Runnable> =
        HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDragDrop {
        val view = LayoutInflater.from(c).inflate(R.layout.drag_inflater_livro, parent, false)
        return ViewHolderDragDrop(view)
    }
    override fun getItemCount(): Int {
        return livro.size
    }

    override fun onBindViewHolder(holder: ViewHolderDragDrop, position: Int) {
        val livroEscolhido = livro[position]
        holder.tituloViewDrag.text = livroEscolhido.TituloLivro
        holder.autorViewDrag.text = livroEscolhido.AutorLivro
        holder.anoViewDrag.text = livroEscolhido.AnoLivro.toString()
        holder.estrelasViewDrag.text = livroEscolhido.EstrelasLivro.toString()


        if(itemsPendingRemoval.contains(livroEscolhido)){
            holder.layoutNormal.setVisibility(View.GONE)
            holder.layoutGone.setVisibility(View.VISIBLE)
            holder.undoButton.setVisibility(View.VISIBLE)
            holder.undoButton.setOnClickListener {
                // usou o undo, remover a pendingRennable
                val pendingRemovalRunnable = pendingRunnables[livroEscolhido]
                pendingRunnables.remove(livroEscolhido)
                if (pendingRemovalRunnable != null) {
                    handler.removeCallbacks(pendingRemovalRunnable)
                }
                itemsPendingRemoval.remove(livroEscolhido)
                //binda novamente para redesenhar
                notifyItemChanged(livro.indexOf(livroEscolhido))
            }
        } else {
            //mostra o padrão
            holder.tituloViewDrag.setText(livroEscolhido.TituloLivro)
            holder.autorViewDrag.setText(livroEscolhido.AutorLivro)
            holder.anoViewDrag.setText(livroEscolhido.AnoLivro.toString())
            holder.estrelasViewDrag.setText(livroEscolhido.EstrelasLivro.toString())

            holder.layoutNormal.setVisibility(View.VISIBLE)
            holder.layoutGone.setVisibility(View.GONE)
            holder.undoButton.setVisibility(View.GONE)
            holder.undoButton.setOnClickListener(null)

        }


    }
    fun remover (position: Int){
        var fruta = livro[position]

        if (livro.contains(fruta)){
            livro.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removerComTempo(position: Int) {

        val fruta = livro[position]
        if (!itemsPendingRemoval.contains(fruta)) {
            itemsPendingRemoval.add(fruta)
            notifyItemChanged(position)
            var pendingRemovalRunnable = Runnable {
                remover(position)
            }
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT)
            pendingRunnables[fruta] = pendingRemovalRunnable
        }
    }

    fun mover(fromPosition: Int, toPosition: Int) {

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(livro, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(livro, i, i - 1)
            }
        }

        notifyItemMoved(fromPosition, toPosition)
        notifyItemChanged(toPosition)
        notifyItemChanged(fromPosition)
    }

}