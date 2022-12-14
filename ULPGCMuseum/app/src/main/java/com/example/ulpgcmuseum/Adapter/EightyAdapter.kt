package com.example.ulpgcmuseum.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ulpgcmuseum.Activity.EightyActivity
import com.example.ulpgcmuseum.Item
import com.example.ulpgcmuseum.R

class EightyAdapter(private val eightyList: ArrayList<Item>, var clickListener: EightyActivity) : RecyclerView.Adapter<EightyAdapter.MyViewHolder>(),
    View.OnClickListener{


    private lateinit var nListener : onItemClickListener

    interface onItemClickListener {

        fun onItemClick(item: Item, position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener){
        nListener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.inventory_item,
            parent, false)

        return MyViewHolder(itemView, nListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //val item : Item = inventoryList[position]
        //holder.Name.text = item.Name

        holder.initialize(eightyList.get(position), clickListener)

    }

    override fun getItemCount(): Int {
        return eightyList.size
    }


    class MyViewHolder(itemView : View, listener : onItemClickListener) : RecyclerView.ViewHolder(itemView){


        val Name : TextView = itemView.findViewById(R.id.tvItem)

        fun initialize(item: Item, action: EightyActivity){
            Name.text = item.Name

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}