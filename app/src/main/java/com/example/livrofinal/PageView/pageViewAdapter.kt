package com.example.livrofinal.PageView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import com.example.livrofinal.View.livroHolder
import org.w3c.dom.Text

class pageViewAdapter(var context: Context, var Livros:List<LivroModelo>):PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.pageviewinflater,container ,false)

        val titulo:TextView = view.findViewById(R.id.TituloPageView)
        titulo.setText(Livros[position].TituloLivro)
        val autor:TextView = view.findViewById(R.id.autorPageView)
        autor.setText(Livros[position].AutorLivro)
        val ano:TextView = view.findViewById(R.id.anoPageView)
        ano.setText(Livros[position].AnoLivro.toString())
        val estrelas:TextView = view.findViewById((R.id.estrelasPageView))
        estrelas.setText(Livros[position].EstrelasLivro.toString())
        container.addView(view)
        return  view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View )
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun getCount(): Int {
        return Livros.size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return Livros[position].TituloLivro
    }

}