package com.example.digitalfood

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerMenu
    lateinit var arrowback: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        arrowback = findViewById(R.id.arrowback_home)
        arrowback.setOnClickListener {
            val intentBack = Intent(this,HomeActivity::class.java)
            startActivity(intentBack)
        }

        initComponents()
    }

    private fun initMenu(): MutableList<Menu>{
        val menu = mutableListOf(
            Menu("Picanha", "url"),
            Menu("Picanha", "url"),
            Menu("Picanha", "url"),
            Menu("Picanha", "url"),
            Menu("Picanha", "url"),
            Menu("Picanha", "url"),
        )
        return menu
    }


    @SuppressLint("WrongConstant")
    private fun initComponents(){
        val menu = initMenu()
        recyclerView = findViewById(R.id.recycler_menu)
        adapter = RecyclerMenu(menu, this)
        recyclerView?.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        recyclerView?.adapter = adapter

    }
}








