package com.dicoding.heromlfauzan

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About me"
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#33cae8")))
    }
}