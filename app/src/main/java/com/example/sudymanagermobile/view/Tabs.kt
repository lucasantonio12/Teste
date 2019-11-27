package com.example.sudymanagermobile.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Tabs(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val disView = DisciplinaView();
    val tarView = TarefaView();


    override fun getItem(position: Int): Fragment? {
        return when (position){
            0->disView
            1->tarView
            else -> null
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Disciplina"
            1->"Tarefa"
            else -> null
        }
    }
}