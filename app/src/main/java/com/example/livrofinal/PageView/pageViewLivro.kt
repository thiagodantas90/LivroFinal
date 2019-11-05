package com.example.livrofinal.PageView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
import com.example.livrofinal.Banco.AppDataBase
import com.example.livrofinal.Modelos.LivroModelo
import com.example.livrofinal.R
import kotlinx.android.synthetic.main.activity_page_view_livro.*

class pageViewLivro : AppCompatActivity() {

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "bancoLivro.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_view_livro)

        val listaLivros:List<LivroModelo> = db.LivroDao().listAll()

        viewpager.adapter = pageViewAdapter(this, listaLivros)
        viewpager.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener,
            OnAdapterChangeListener {
            override fun onAdapterChanged(
                viewPager: ViewPager,
                oldAdapter: PagerAdapter?,
                newAdapter: PagerAdapter?
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrollStateChanged(state: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageSelected(position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.i("AULA17", "onPageScrolled chamado, posição: "+position);
            }


        })
    }
}
