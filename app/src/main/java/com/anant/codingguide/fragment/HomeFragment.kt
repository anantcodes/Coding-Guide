package com.anant.codingguide.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.anant.codingguide.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.DateFormat
import java.util.*


class HomeFragment : Fragment() {

    lateinit var txtDate: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)


        txtDate=view.findViewById(R.id.txtDate)


        val rightNow = Calendar.getInstance()
        val currentDate:String= DateFormat.getInstance().format(rightNow.time)
        txtDate.text = currentDate



        return view
    }


}