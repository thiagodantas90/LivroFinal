package com.example.livrofinal.ViewRecycle

import android.media.Rating
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livrofinal.R

class viewHolderRecy(v:View):RecyclerView.ViewHolder(v){
    var tituloText: TextView
    var autorText: TextView
    var anoText: TextView
    var estrelasText: TextView


    init {
        tituloText = v.findViewById(R.id.tituloListaViewRecy)
        autorText = v.findViewById(R.id.autorListaViewRecy)
        anoText = v.findViewById(R.id.anoListaViewRecy)
        estrelasText = v.findViewById(R.id.astarListaViewRecy)
    }
}