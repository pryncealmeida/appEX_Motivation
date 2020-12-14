package com.example.appex_motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appex_motivation.R
import com.example.appex_motivation.infra.MotivationConstants
import com.example.appex_motivation.infra.SecurityPreferences
import com.example.appex_motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mphraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)
        t1_main.text =
            "Olá, " + mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME).toString()


        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btn_newPhrase.setOnClickListener(this)
        img_infinit.setOnClickListener(this)
        img_smile.setOnClickListener(this)
        img_sunny.setOnClickListener(this)

        //Execução Inicial
        img_infinit.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()




    }

    override fun onClick(view: View) {

        val idv = view.id
        val listFilter = listOf(R.id.img_infinit, R.id.img_smile, R.id.img_sunny)

        if (idv == R.id.btn_newPhrase) {
            handleNewPhrase()
        } else if (idv in listFilter) {
            handleFilter(idv)
        }


    }

    private fun handleFilter(idv: Int) {
        img_infinit.setColorFilter(resources.getColor(R.color.white))
        img_smile.setColorFilter(resources.getColor(R.color.white))
        img_sunny.setColorFilter(resources.getColor(R.color.white))



        when (idv) {
            R.id.img_infinit -> {
                img_infinit.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.img_smile -> {
                img_smile.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.SMILE
            }
            R.id.img_sunny -> {
                img_sunny.setColorFilter(resources.getColor(R.color.colorAccent))
                mphraseFilter = MotivationConstants.PHRASEFILTER.SUNNY
            }
        }


    }

    private fun handleNewPhrase() {
        phrase.text = Mock().getPhrase(mphraseFilter)
    }
}