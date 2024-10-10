package com.example.shessyoach.data_control

import android.content.Context
import com.example.shessyoach.R

class MenuItems(private val context: Context) {
    val menus: List<MenuCell> = listOf(
        MenuCell(R.drawable.ic_action_name, "Game History", com.example.shessyoach.activities.GameHistory::class.java, true),
        MenuCell(R.drawable.ic_action_name, "Settings", com.example.shessyoach.activities.Settings::class.java, false),
        MenuCell(R.drawable.ic_action_name, "Multy Play", com.example.shessyoach.activities.MultyPlay::class.java, true),
        MenuCell(R.drawable.ic_action_name, "Single Play", com.example.shessyoach.activities.SinglePlay::class.java, false),
        MenuCell(R.drawable.ic_action_name, "Quest", com.example.shessyoach.activities.Quest::class.java, true),
        MenuCell(R.drawable.ic_action_name, "History Party", com.example.shessyoach.activities.HistoryParty::class.java, true)
    )
}

data class MenuCell(
    val iconResId: Int,
    val title: String,
    val activityClass: Class<*>,
    val isOnline: Boolean
)
