package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ReceiptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val receiptTextView: TextView = findViewById(R.id.receiptTextView)
        val receiptData = intent.getStringExtra("RECEIPT_DATA")

        receiptTextView.text = receiptData
    }
}