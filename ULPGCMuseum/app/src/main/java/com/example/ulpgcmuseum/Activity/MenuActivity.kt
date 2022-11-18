package com.example.ulpgcmuseum.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.bumptech.glide.load.model.stream.UrlLoader

import com.example.ulpgcmuseum.R
import java.net.URL

class MenuActivity : AppCompatActivity() {

    public var _url : String = "https://www.ulpgc.es/"
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


        val newsButton=findViewById<Button>(R.id.news)
        newsButton.setOnClickListener{

                var _link : Uri = Uri.parse("https://www.ulpgc.es/")
                var i  = Intent(Intent.ACTION_VIEW, _link)
                startActivity(i)

        }


    }
}