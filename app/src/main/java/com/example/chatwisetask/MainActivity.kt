package com.example.chatwisetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var viewImageBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewImageBtn = findViewById(R.id.image_button)


        viewImageBtn.setOnClickListener {
            // In your source activity
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}