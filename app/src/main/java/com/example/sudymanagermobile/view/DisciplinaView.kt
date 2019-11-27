package com.example.sudymanagermobile.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sudymanagermobile.R
import kotlinx.android.synthetic.main.activity_disciplina_recicly.*


class DisciplinaView : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.activity_disciplina_recicly, container, false)

    }
}