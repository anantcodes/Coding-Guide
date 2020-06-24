package com.anant.codingguide.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.anant.codingguide.R
import kotlinx.android.synthetic.main.activity_control.*
import kotlinx.android.synthetic.main.fragment_competitiveprogramming.*
import java.lang.reflect.Array.newInstance
import java.security.cert.CertPathBuilder.getInstance
import java.util.Calendar.getInstance


class CompetitiveProgrammingFragment : Fragment() {

    lateinit var txtHere1:TextView
    lateinit var txtHere2:TextView
    lateinit var txtHere3:TextView
    lateinit var txtHere4:TextView
    lateinit var txtHere5:TextView
    lateinit var btnCodeChef:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_competitiveprogramming, container, false)


        txtHere1=view.findViewById(R.id.txtHere1)
        txtHere2=view.findViewById(R.id.txtHere2)
        txtHere3=view.findViewById(R.id.txtHere3)
        txtHere4=view.findViewById(R.id.txtHere4)
        txtHere5=view.findViewById(R.id.txtHere5)
        btnCodeChef=view.findViewById(R.id.btnCodeChef)


        txtHere1.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frame,LanguagesFragment())?.commit()
            activity?.title = "Programming Languages"
        }


        txtHere2.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Time_complexity")))

        }

        txtHere3.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Space_complexity")))

        }

        txtHere4.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/data-structures/")))

        }

        txtHere5.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/fundamentals-of-algorithms/")))

        }

        btnCodeChef.setOnClickListener {
            activity?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codechef.com/problems/school/?sort_by=SuccessfulSubmission&sorting_order=desc")))

        }









        return view
    }


}