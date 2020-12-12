package com.example.appex_motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appex_motivation.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null){
            supportActionBar!!.hide()
        }
    }
}