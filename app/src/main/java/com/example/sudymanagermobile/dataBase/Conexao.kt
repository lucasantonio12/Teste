package com.example.sudymanagermobile.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sudymanagermobile.dao.DisciplinaDAO
import com.example.sudymanagermobile.dao.TarefaDAO
import com.example.sudymanagermobile.modelo.Disciplina
import com.example.sudymanagermobile.modelo.Tarefa

@Database(entities = [Disciplina::class,Tarefa::class], version = 1)
abstract class Conexao:RoomDatabase() {
    abstract  fun DisciplinaDAO():DisciplinaDAO
    abstract  fun TarefaDAO():TarefaDAO
}