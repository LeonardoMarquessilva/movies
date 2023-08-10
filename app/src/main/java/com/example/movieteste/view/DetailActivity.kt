package com.example.movieteste.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.movieteste.R

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        textViewDescription.text = intent.getStringExtra("overview")

    }
}