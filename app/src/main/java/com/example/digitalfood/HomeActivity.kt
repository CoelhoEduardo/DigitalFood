package com.example.digitalfood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerHome
    lateinit var arrowHome: ImageButton
    lateinit var itemCard: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        arrowHome = findViewById(R.id.arrowback_home)
        arrowHome.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
        }

        initComponents()


    }


    private fun initRestaurantsList(): MutableList<Restaurantes>{
        val lrestaurante = mutableListOf(
            Restaurantes("Pizza Hut", "R. Humberto I, 440 - Vila Mariana / Horário: 12:00 - 22:00","https://www.saboravida.com.br/wp-content/uploads/2021/04/cardapio-pizza-hut.jpg"),
            Restaurantes("Outback","R. Frei Caneca, 569 - 3º andar - Consolação / Horário: 12:00 - 23:00","https://www.saboravida.com.br/wp-content/uploads/2021/02/cardapio-outback-steakhouse.jpg"),
            Restaurantes("McDonalds", "Av. Brigadeiro Luís Antônio, 3477/3481 - Paraíso / Horário: 09:00 - 23:00","https://www.saboravida.com.br/wp-content/uploads/2021/01/cardapio-mcdonalds.jpg"),
            Restaurantes("Burguer King","Rua Javari, 403 - Mooca / Horário: 09:00 - 23:00 ","https://static.poder360.com.br/2021/11/lanche-Burger-King-868x644.jpg"),
            Restaurantes("Coco Bambu","R. Azevedo Soares, 2150 - Jardim Analia Franco / Horário: 11:00 - 00:00","https://riodegusta.com.br/wp-content/uploads/2021/02/Rede-de-Pescador_1-1.jpg"),
            Restaurantes("Sukiya","R. da Mooca, 2554 - Mooca / Horário: 11:00 - 22:30","https://d1ralsognjng37.cloudfront.net/480a1ca2-ae94-4223-b7c4-c61f50c0977e.jpeg")
        )

        return lrestaurante
    }

    @SuppressLint("WrongConstant")
    private fun initComponents(){

        val lrestaurantes = initRestaurantsList()
        recyclerView = findViewById(R.id.recycler_view)
        adapter = RecyclerHome(lrestaurantes, this)
        recyclerView?.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        recyclerView?.adapter = adapter
        recyclerView.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }



    }
}