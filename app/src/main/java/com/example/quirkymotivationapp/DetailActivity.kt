package com.example.quirkymotivationapp

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DetailActivity : AppCompatActivity() {

    private lateinit var quotes: Array<String>
    private lateinit var tvQuote: TextView
    private lateinit var currentQuote: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        quotes = resources.getStringArray(R.array.motivational_quotes)
        tvQuote = findViewById(R.id.tvQuote)
        val btnNewQuote = findViewById<FrameLayout>(R.id.btnNewQuote)
        val btnShare = findViewById<FrameLayout>(R.id.btnShare)

        // Load initial quote
        loadNewQuote()

        btnNewQuote.setOnClickListener {
            loadNewQuote()
        }

        btnShare.setOnClickListener {
            shareQuote()
        }
    }

    private fun loadNewQuote() {
        currentQuote = quotes[Random.nextInt(quotes.size)]
        tvQuote.text = currentQuote
    }

    private fun shareQuote() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "$currentQuote\n\n- Sent from Quirky Motivation App ✨")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share Quote"))
    }
}