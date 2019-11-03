package com.example.livrofinal.DragDrop

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livrofinal.R

class ViewHolderDragDrop (v: View) : RecyclerView.ViewHolder(v){
    val tituloViewDrag: TextView = v.findViewById(R.id.TituloDrag)
    val autorViewDrag: TextView = v.findViewById(R.id.autorDrag)
    val anoViewDrag: TextView = v.findViewById(R.id.anoDrag)
    val estrelasViewDrag: TextView = v.findViewById(R.id.estrelasDrag)

    val layoutNormal: LinearLayout = v.findViewById(R.id.layout_normal)
    val layoutGone: LinearLayout = v.findViewById(R.id.layout_gone)

    val undoButton: Button = v.findViewById(R.id.undo_button)
}