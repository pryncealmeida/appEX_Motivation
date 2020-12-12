package com.example.appex_motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appex_motivation.R
import com.example.appex_motivation.infra.MotivationConstants
import com.example.appex_motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSecurityPreferences: SecurityPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        t1_main.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME).toString()


        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}