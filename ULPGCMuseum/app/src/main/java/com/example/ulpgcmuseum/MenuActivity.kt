package com.example.ulpgcmuseum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.ImageButton

import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuButton=findViewById<ImageButton>(R.id.expandedMenu)
        menuButton.setOnClickListener {
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }

        val settingsButton=findViewById<Button>(R.id.settings)
        settingsButton.setOnClickListener {
            val settingsActivity = Intent(this, SettingsActivity::class.java)
            startActivity(settingsActivity)
        }

        val inventoryButton=findViewById<Button>(R.id.inventory)
        inventoryButton.setOnClickListener {
            val elementActivity = Intent(this, InventoryActivity::class.java)
            startActivity(elementActivity)
        }


    }
}