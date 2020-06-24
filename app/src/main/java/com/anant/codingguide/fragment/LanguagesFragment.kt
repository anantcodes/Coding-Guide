package com.anant.codingguide.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.anant.codingguide.R
import kotlinx.android.synthetic.main.fragment_languages.*


class LanguagesFragment : Fragment() {

   lateinit var btnJava:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_languages, container, false)

       btnJava=view.findViewById(R.id.btnJava)

        btnJava.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/java-tutorials/?ref=lbp"))
            activity?.startActivity(i)

        }





        return view




    }


}