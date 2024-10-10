package com.example.shessyoach.activities

import MenuAdapter
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shessyoach.R
import com.example.shessyoach.data_control.MenuItems

import com.example.shessyoach.data_control.WebSocketClient

class MainActivity : AppCompatActivity() {

    private lateinit var webSocketClient: WebSocketClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pregen

        webSocketClient = WebSocketClient("ws://95.165.27.159:7502")
        webSocketClient.start()

        val menuItems = MenuItems(this)

        val recyclerView: RecyclerView = findViewById(R.id.menu_ui)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MenuAdapter(this, menuItems)
        recyclerView.adapter = adapter
    }


    fun activateLoginPage(view: View){

    }
}