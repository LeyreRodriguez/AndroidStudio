package com.example.ulpgcmuseum


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class InventoryActivity : AppCompatActivity(), MyAdapter.onItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemArrayList : ArrayList<Item>
    private lateinit var myAdapter: MyAdapter

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inventory)

        recyclerView = findViewById(R.id.inventoryList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        itemArrayList = arrayListOf()



        myAdapter = MyAdapter(itemArrayList,this)


        recyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(item: Item, position: Int) {
                TODO("Not yet implemented")
            }
        })

        EventChangeListener()

    }


    private fun EventChangeListener(){

        db = FirebaseFirestore.getInstance()


        db.collection("Inventory").addSnapshotListener(object : EventListener<QuerySnapshot>{
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {

                if (error != null){
                    Log.e("Firestore Error", error.message.toString())
                }

                for(dc : DocumentChange in value?.documentChanges!!){

                    if ( dc.type == DocumentChange.Type.ADDED){

                        itemArrayList.add(dc.document.toObject(Item::class.java))
                    }
                }

                myAdapter.notifyDataSetChanged()




            }

        })



    }

    override fun onItemClick(item: Item, position: Int) {
      //  Toast.makeText(this, item.Name, Toast.LENGTH_LONG).show()

        val intent = Intent(this,ItemActivity::class.java)
        intent.putExtra("Name", item.Name)
        startActivity(intent)


    }


}