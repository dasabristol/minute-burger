package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ReceiptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val receiptTextView: TextView = findViewById(R.id.receiptTextView)
        val receiptData = intent.getStringExtra("RECEIPT_DATA")

        val btnOrderAgain = findViewById<Button>(R.id.OrderAgain)

        receiptTextView.text = receiptData

        btnOrderAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}