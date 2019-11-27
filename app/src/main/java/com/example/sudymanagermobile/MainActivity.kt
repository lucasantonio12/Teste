package com.example.sudymanagermobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sudymanagermobile.view.CadastraDisciplina
import com.example.sudymanagermobile.view.Tabs
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageAdapter = Tabs(supportFragmentManager)

        viewpager.adapter = pageAdapter

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    0 -> {
                        tab.getTabAt(0)!!.setText("Disciplina")
                    }
                    1 -> {
                        tab.getTabAt(0)!!.setText("Tarefa")

                    }
                    else -> return
                }
            }

            override fun onPageSelected(position: Int) {
            }

        })

    }
}
