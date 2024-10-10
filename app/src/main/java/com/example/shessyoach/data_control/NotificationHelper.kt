package com.example.shessyoach.helpers

import android.content.Context
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment

class NotificationHelper {

    // Метод для отображения Toast уведомления
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    // Метод для отображения Snackbar уведомления
    fun showSnackbar(fragment: Fragment, message: String) {
        Snackbar.make(fragment.requireView(), message, Snackbar.LENGTH_SHORT).show()
    }
}
