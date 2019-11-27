package com.example.sudymanagermobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.sudymanagermobile.R
import com.example.sudymanagermobile.dataBase.Conexao
import com.example.sudymanagermobile.dataBase.Conexao_Impl
import com.example.sudymanagermobile.modelo.Disciplina
import kotlinx.android.synthetic.main.activity_cadastra_disciplina.*

class CadastraDisciplina : AppCompatActivity() {

    val conexao:Conexao by lazy{
        Room.databaseBuilder(this,Conexao::class.java,"dataBaseStudyManager")
            .allowMainThreadQueries().build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra_disciplina)

        saveDisciplina.setOnClickListener {
            conexao.DisciplinaDAO().inserir(Disciplina(nomeDisciplina.text.toString(),conteudoDisciplina.text.toString()))
            conexao.DisciplinaDAO().listAll().forEach{ (Log.i("Disciplinas",it.toString()))}
            nomeDisciplina.setText("")
            conteudoDisciplina.setText("")
        }
    }
}
