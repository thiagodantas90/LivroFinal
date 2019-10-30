package com.example.livrofinal.View

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.viewmodel.view.*

class livroHolder(v: View){
    var titulotext:TextView
    var autoText:TextView
    var anoText:TextView
    var estrelasRating: RatingBar

    init {
        titulotext = v.findViewById(R.id.tituloListaView)
        autoText = v.findViewById(R.id.autorListaView)
        anoText = v.findViewById(R.id.anoListaView)
        estrelasRating = v.findViewById(R.id.starListaView)
    }
}