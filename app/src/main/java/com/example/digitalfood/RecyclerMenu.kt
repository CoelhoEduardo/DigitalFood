package com.example.digitalfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerMenu(
    var menu: MutableList<Menu>,
    private var menuView: MenuActivity
) : RecyclerView.Adapter<RecyclerMenu.MenuViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)

        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.size
    }


    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imagePratos: ImageButton = itemView.findViewById(R.id.imagePrato)
        val prato: TextView = itemView.findViewById(R.id.prato)


    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        Picasso.get()
            .load(menu[position].imagePrato)
            .placeholder(R.drawable.fastfood)
            .into((holder.imagePratos))

        holder.prato.text = menu[position].prato
    }

}