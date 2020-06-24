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
    lateinit var btnCPlus:Button
    lateinit var btnC:Button
    lateinit var btnPython:Button
    lateinit var btnKotlin:Button
    lateinit var btnJS:Button
    lateinit var btnGo:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_languages, container, false)

       btnJava=view.findViewById(R.id.btnJava)
        btnCPlus=view.findViewById(R.id.btnCPlus)
        btnC=view.findViewById(R.id.btnC)
        btnPython=view.findViewById(R.id.btnPython)
        btnKotlin=view.findViewById(R.id.btnKotlin)
        btnJS=view.findViewById(R.id.btnJS)
        btnGo=view.findViewById(R.id.btnGo)

        btnJava.setOnClickListener {

            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/java-tutorials/")))

        }

        btnCPlus.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/cpp-tutorial/")))

        }

        btnC.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/c-programming-language/")))

        }


        btnPython.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/python-tutorial/")))

        }


        btnKotlin.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/kotlin-programming-language/")))

        }

        btnJS.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/javascript-tutorial/")))

        }

        btnGo.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/golang-tutorial-learn-go-programming-language/")))

        }









        return view




    }


}