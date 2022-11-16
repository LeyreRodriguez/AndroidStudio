package com.example.ulpgcmuseum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import java.time.Year


class ItemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        getIncomingIntent()

    }

    private fun getIncomingIntent(){

        if(intent.hasExtra("Name")){

            var texto : String? = intent.getStringExtra("Name")
            var imageUrl : String? = intent.getStringExtra("Image")
            var year : String? = intent.getStringExtra("Year")
            var description : String? = intent.getStringExtra("Description")
            setText(texto.toString(), imageUrl.toString(), year.toString(), description.toString())
        }

    }

    private fun setText(texto : String, Image : String, Year: String, Description : String){
        val name : TextView = findViewById(R.id.tvName)
        val image : ImageView = findViewById(R.id.tvImage)
        val year : TextView = findViewById(R.id.tvYear)
        val description : TextView = findViewById(R.id.tvDescription)
        name.setText(texto)
        year.setText(Year)
        description.setText(Description)


        Glide.with(this).asBitmap().load(Image).into(image)

    }
}