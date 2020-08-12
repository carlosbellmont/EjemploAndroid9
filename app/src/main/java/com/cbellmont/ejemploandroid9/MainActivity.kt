package com.cbellmont.ejemploandroid9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

// Icons made by Freepik from https://www.flaticon.com/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val football = Sport("Futbol", R.mipmap.football)
        val basket = Sport("Basket", R.mipmap.basketball)
        val tennis = Sport("Tennis", R.mipmap.tennis)
        val list = listOf(football, basket, tennis)

        var selectedSport = list[Random.nextInt(3)]
        mostrarDeporte(selectedSport)

        button.setOnClickListener {
            var sportCandidate : Sport
            do {
                sportCandidate = list[Random.nextInt(3)]
            } while (selectedSport.name.contentEquals(sportCandidate.name))
            selectedSport = sportCandidate
            mostrarDeporte(selectedSport)
        }
    }

    fun mostrarDeporte(sport : Sport){
        textView.text = sport.name
        imageView.setImageResource(sport.imageId)
    }
}