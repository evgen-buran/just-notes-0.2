package com.example.justnotes02.utils

import android.widget.Toast

fun showToast(msg: String): Unit {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}