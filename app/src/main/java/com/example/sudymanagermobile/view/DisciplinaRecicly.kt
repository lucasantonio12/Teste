package com.example.sudymanagermobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.sudymanagermobile.R
import com.example.sudymanagermobile.dataBase.Conexao
import kotlinx.android.synthetic.main.activity_disciplina_recicly.*

class DisciplinaRecicly : AppCompatActivity() {
    val conexao: Conexao by lazy{
        Room.databaseBuilder(this, Conexao::class.java,"dataBaseStudyManager")
            .allowMainThreadQueries().build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina_recicly)

        buttonSave.setOnClickListener {
            Toast.makeText(this,"OIIIIIIIIIIIIIIIIIII", Toast.LENGTH_SHORT).show()
        }

    }
}
