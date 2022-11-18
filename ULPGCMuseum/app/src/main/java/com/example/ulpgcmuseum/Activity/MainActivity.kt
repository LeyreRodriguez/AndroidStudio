package com.example.ulpgcmuseum.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.ulpgcmuseum.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton=findViewById<ImageButton>(R.id.expanded_menu)
        menuButton.setOnClickListener {
            val menuActivity = Intent(this, MenuActivity::class.java)
            startActivity(menuActivity)
        }

        val seventy = findViewById<Button>(R.id.setenta)
        seventy.setOnClickListener {
            val seventyActivity = Intent(this, SeventyActivity::class.java)
            startActivity(seventyActivity)
        }


        val eighty=findViewById<Button>(R.id.ochenta)
        eighty.setOnClickListener {
            val eightyActivity = Intent(this, EightyActivity::class.java)
            startActivity(eightyActivity)
        }

        val ninety=findViewById<Button>(R.id.noventa)
        ninety.setOnClickListener {
            val ninetyActivity = Intent(this, NinetyActivity::class.java)
            startActivity(ninetyActivity)
        }




    }



}