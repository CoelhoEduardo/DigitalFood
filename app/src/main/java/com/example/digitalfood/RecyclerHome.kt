package com.example.digitalfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerHome (
    private var lrestaurantes: List<Restaurantes>,
    private val homeView: HomeActivity
): RecyclerView.Adapter<RecyclerHome.RestaurantesViewHolder>(){
    lateinit var actionImage: ImageButton


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurantes,parent,false)

        return RestaurantesViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RestaurantesViewHolder,
        position: Int
    ) {
        Picasso.get()
            .load(lrestaurantes[position].imageRestaurantes)
            .placeholder(R.drawable.ic_launcher_background)
            .into((holder.actionImage))

        holder.name.text = lrestaurantes[position].nomeRestaurantes

        holder.adress.text = lrestaurantes[position].adressText


    }


    override fun getItemCount(): Int {
        return lrestaurantes.size
    }

    class RestaurantesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var actionImage: ImageButton =  itemView.findViewById(R.id.action_image)
        var name: TextView = itemView.findViewById(R.id.name)
        var adress: TextView = itemView.findViewById(R.id.adress)

    }

}
