package com.example.ulpgcmuseum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton=findViewById<ImageButton>(R.id.expanded_menu)
        menuButton.setOnClickListener {
            val menuActivity = Intent(this, MenuActivity::class.java)
            startActivity(menuActivity)
        }


    }



}