package com.example.sudymanagermobile.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_disciplina")
data class Disciplina(var nome:String, var conteudo:String) {
    @PrimaryKey (autoGenerate = true)
    var id = 0
}