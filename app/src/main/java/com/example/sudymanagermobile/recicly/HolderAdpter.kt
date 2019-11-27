package com.example.sudymanagermobile.recicly

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sudymanagermobile.R
import kotlinx.android.synthetic.main.recicly.view.*

class HolderAdpter(v: View): RecyclerView.ViewHolder(v){
     val nome:TextView = v.findViewById(R.id.disciplinaView)
     val descricao:TextView = v.findViewById(R.id.descricaoView)
     val layoutGone: LinearLayout = v.findViewById(R.id.layout_gone)
     val layoutNormal: LinearLayout = v.findViewById(R.id.layout_normal)
     val undoButton: Button = v.findViewById(R.id.undo_button)
}