package com.cbellmont.ejemploandroid9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cbellmont.ejemploandroid9.databinding.ActivityMainBinding
import kotlin.random.Random

// Icons made by Freepik from https://www.flaticon.com/
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val football = Sport("Futbol", R.mipmap.football)
        val basket = Sport("Basket", R.mipmap.basketball)
        val tennis = Sport("Tennis", R.mipmap.tennis)
        val list = listOf(football, basket, tennis)

        var selectedSport = list[Random.nextInt(list.size)]
        mostrarDeporte(selectedSport)

        binding.button.setOnClickListener {
            var sportCandidate : Sport
            do {
                sportCandidate = list[Random.nextInt(list.size)]
            } while (selectedSport.name.contentEquals(sportCandidate.name))
            selectedSport = sportCandidate
            mostrarDeporte(selectedSport)
        }
    }

    fun mostrarDeporte(sport : Sport){
        binding.textView.text = sport.name
        binding.imageView.setImageResource(sport.imageId)
    }
}