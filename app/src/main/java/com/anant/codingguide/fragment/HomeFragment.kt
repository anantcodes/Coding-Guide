package com.anant.codingguide.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
//import android.media.audiofx.BassBoost
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.ACTION_WIRELESS_SETTINGS
//import androidx.provider.Settings.ACTION_WIRELESS_SETTINGS
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.anant.codingguide.R
import com.anant.codingguide.util.ConnectionManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.nio.channels.spi.AsynchronousChannelProvider.provider
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
        if(ConnectionManager().checkConnectivity(activity as Context)) {

            txtDate = view.findViewById(R.id.txtDate)


            val rightNow = Calendar.getInstance()
            val currentDate: String = DateFormat.getInstance().format(rightNow.time)
            txtDate.text = currentDate

        }
        else
        {
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection is not Found")
            dialog.setPositiveButton("Open Settings") { text, listener ->

                val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                activity?.finish()


            }

            dialog.setNegativeButton("Exit") { text, listener ->

                ActivityCompat.finishAffinity(activity as Activity)


            }
            dialog.create()
            dialog.show()
        }






        return view
    }


}