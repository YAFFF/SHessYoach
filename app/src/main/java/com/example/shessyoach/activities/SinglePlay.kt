package com.example.shessyoach.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shessyoach.R
import com.example.shessyoach.fragments.LeftMenuFragment

class SinglePlay : AppCompatActivity() {


    private var isMenuVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_single_play)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onBackPressed() {
        // Проверяем, видимо ли боковое меню
        if (isMenuVisible) {
            // Если меню открыто, закрываем его
            hideMenuFragment()
        } else {
            // Иначе показываем боковое меню
            showMenuFragment()
        }
    }

    private fun showMenuFragment() {
        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        fragmentContainer.visibility = View.VISIBLE
        isMenuVisible = true

        val fragment = LeftMenuFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun hideMenuFragment() {
        // Удаляем фрагмент и скрываем контейнер
        supportFragmentManager.popBackStack()
        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        fragmentContainer.visibility = View.GONE
        isMenuVisible = false
    }
}