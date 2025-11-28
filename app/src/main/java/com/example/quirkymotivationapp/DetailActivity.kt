package com.example.quirkymotivationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val quotes = resources.getStringArray(R.array.motivational_quotes)
        val randomQuote = quotes[Random.nextInt(quotes.size)]

        val tvQuote = findViewById<TextView>(R.id.tvQuote)
        tvQuote.text = randomQuote
    }
}