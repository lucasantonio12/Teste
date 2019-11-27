package com.example.sudymanagermobile.recicly

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sudymanagermobile.R
import com.example.sudymanagermobile.modelo.Disciplina
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class AdpterDis(var context: Context, var listDis:MutableList<Disciplina>) : RecyclerView.Adapter<HolderAdpter>() {
    private val PENDING_REMOVAL_TIMEOUT:Long = 2000
    var itemsPendingRemoval = ArrayList<Disciplina>()

    private val handler = Handler()
    var pendingRunnables: HashMap<Disciplina, Runnable> =
        HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAdpter {
        val view = LayoutInflater.from(context).inflate(R.layout.recicly,parent,false)
        return  HolderAdpter(view)
    }

    override fun getItemCount(): Int {
        return listDis.size
    }

    override fun onBindViewHolder(holder: HolderAdpter, position: Int) {
        val disSelecionada = listDis[position]

        holder.nome.text = disSelecionada.nome
        holder.descricao.text = disSelecionada.conteudo


        if (itemsPendingRemoval.contains(disSelecionada)){
            holder.layoutNormal.setVisibility(View.GONE)
            holder.layoutGone.setVisibility(View.VISIBLE)
            holder.undoButton.setVisibility(View.VISIBLE)
            holder.undoButton.setOnClickListener {
                val pendingRemovalRunnable = pendingRunnables[disSelecionada]
                Log.i("AULA17", "CLICOU")
                pendingRunnables.remove(disSelecionada)
                if (pendingRemovalRunnable != null) {
                    handler.removeCallbacks(pendingRemovalRunnable)
                }
                itemsPendingRemoval.remove(disSelecionada)
                //binda novamente para redesenhar
                notifyItemChanged(listDis.indexOf(disSelecionada))
            }
        }else{
            holder.nome.setText(disSelecionada.nome)
            holder.layoutNormal.setVisibility(View.VISIBLE)
            holder.layoutGone.setVisibility(View.GONE)
            holder.undoButton.setVisibility(View.GONE)
            holder.undoButton.setOnClickListener(null)

        }
    }

    fun remove (position: Int){
        var book = listDis[position]

        if (listDis.contains(book)){
            listDis.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun removeTime(position: Int) {

        val book = listDis[position]
        if (!itemsPendingRemoval.contains(book)) {
            itemsPendingRemoval.add(book)
            notifyItemChanged(position)
            var pendingRemovalRunnable = Runnable {
                remove(position)
            }
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT)
            pendingRunnables[book] = pendingRemovalRunnable
        }
    }

    fun mover(fromPosition: Int, toPosition: Int) {

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(listDis, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(listDis, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        notifyItemChanged(toPosition)
        notifyItemChanged(fromPosition)
    }
}