package com.example.ulpgcmuseum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ItemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        getIncomingIntent()

    }

    private fun getIncomingIntent(){

        if(intent.hasExtra("Name")){

            var texto : String? = intent.getStringExtra("Name")
            // var imageUrl : String = intent.getStringExtra("imageUrl")
            setText(texto.toString())
        }

    }

    private fun setText(texto : String){
        val name : TextView = findViewById(R.id.tvName)
        name.setText(texto)

        /* val ImageView image = findViewById(R.id.tvImage)
        Glide.with(this).asBitmap().load(imageUrl).into(image)
         */
    }
}