package com.example.sudymanagermobile.view

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.method.Touch
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

import com.example.sudymanagermobile.R
import com.example.sudymanagermobile.dataBase.Conexao
import com.example.sudymanagermobile.modelo.Disciplina
import com.example.sudymanagermobile.recicly.AdpterDis
import kotlinx.android.synthetic.main.activity_cadastra_disciplina.*
import kotlinx.android.synthetic.main.fragment_teste3.*


class teste3 : Fragment() {
    val conexao: Conexao by lazy{
        Room.databaseBuilder(context!! , Conexao::class.java,"dataBaseStudyManager")
            .allowMainThreadQueries().build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teste3, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cadastro.setOnClickListener {
            var i = Intent(context,CadastraDisciplina::class.java)
            startActivity(i)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}
