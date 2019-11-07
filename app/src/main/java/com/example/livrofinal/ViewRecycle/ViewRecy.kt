package com.example.livrofinal.ViewRecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_view_recy.*

class ViewRecy : AppCompatActivity() {
    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_recy)
        var listaLivros:MutableList<LivroModelo> = db.LivroDao().listAll() as MutableList<LivroModelo>
        var adapter = viewAdapterRecy(this, listaLivros )
        viewRecycleHolder.adapter = adapter
        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        viewRecycleHolder.layoutManager = layout


        viewRecycleHolder.addOnItemTouchListener(
            MyRecyclerViewClickListener(
                this@ViewRecy,
                viewRecycleHolder,
                object : MyRecyclerViewClickListener.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                        var selecionada = listaLivros[position]

                        Toast.makeText(this@ViewRecy, selecionada.TituloLivro, Toast.LENGTH_SHORT)
                            .show()
                    }
                    override fun onItemLongClick(view: View, position: Int) {
                        val removida =   listaLivros[position]
                        listaLivros.remove(removida)
                        viewRecycleHolder.adapter!!.notifyItemRemoved(position)
                        val snack = Snackbar.make(
                            viewRecycleHolder.parent as View,"Removido",Snackbar.LENGTH_LONG )
                            .setAction("Cancelar") {
                                listaLivros.add(position, removida)
                                viewRecycleHolder.adapter!!.notifyItemInserted(position)
                            }
                        snack.show()
                    }

                }
            )
        )

    }
}
