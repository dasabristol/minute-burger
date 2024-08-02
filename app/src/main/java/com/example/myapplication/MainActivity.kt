package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var decrementButton1: Button
    private lateinit var incrementButton1: Button
    private lateinit var priceTextView1: TextView
    private lateinit var quantityTextView1: TextView
    private val pricePerItem1 = 99.50
    private var quantity1 = 0

    private lateinit var decrementButton2: Button
    private lateinit var incrementButton2: Button
    private lateinit var priceTextView2: TextView
    private lateinit var quantityTextView2: TextView
    private val pricePerItem2 = 85.50
    private var quantity2 = 0

    private lateinit var decrementButton3: Button
    private lateinit var incrementButton3: Button
    private lateinit var priceTextView3: TextView
    private lateinit var quantityTextView3: TextView
    private val pricePerItem3 = 105.50
    private var quantity3 = 0

    private lateinit var orderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton1 = findViewById(R.id.decrement)
        incrementButton1 = findViewById(R.id.increment)
        priceTextView1 = findViewById(R.id.priceText)
        quantityTextView1 = findViewById(R.id.quantity1)

        decrementButton2 = findViewById(R.id.decrement1)
        incrementButton2 = findViewById(R.id.increment1)
        priceTextView2 = findViewById(R.id.priceText1)
        quantityTextView2 = findViewById(R.id.quantity2)

        decrementButton3 = findViewById(R.id.decrement3)
        incrementButton3 = findViewById(R.id.increment3)
        priceTextView3 = findViewById(R.id.priceText3)
        quantityTextView3 = findViewById(R.id.quantity3)

        orderButton = findViewById(R.id.order)

        updatePrice1()
        updatePrice2()
        updatePrice3()

        decrementButton1.setOnClickListener {
            if (quantity1 > 0) {
                quantity1--
                updateQuantity1()
                updatePrice1()
            }
        }

        incrementButton1.setOnClickListener {
            quantity1++
            updateQuantity1()
            updatePrice1()
        }

        decrementButton2.setOnClickListener {
            if (quantity2 > 0) {
                quantity2--
                updateQuantity2()
                updatePrice2()
            }
        }

        incrementButton2.setOnClickListener {
            quantity2++
            updateQuantity2()
            updatePrice2()
        }

        decrementButton3.setOnClickListener {
            if (quantity3 > 0) {
                quantity3--
                updateQuantity3()
                updatePrice3()
            }
        }

        incrementButton3.setOnClickListener {
            quantity3++
            updateQuantity3()
            updatePrice3()
        }

        orderButton.setOnClickListener {
            val receipt = generateReceipt()
            val intent = Intent(this, ReceiptActivity::class.java)
            intent.putExtra("RECEIPT_DATA", receipt)
            startActivity(intent)
        }
    }

    private fun updateQuantity1() {
        quantityTextView1.text = quantity1.toString()
    }

    private fun updatePrice1() {
        val totalPrice1 = pricePerItem1 * quantity1
        priceTextView1.text = String.format("₱%.2f", totalPrice1)
    }

    private fun updateQuantity2() {
        quantityTextView2.text = quantity2.toString()
    }

    private fun updatePrice2() {
        val totalPrice2 = pricePerItem2 * quantity2
        priceTextView2.text = String.format("₱%.2f", totalPrice2)
    }

    private fun updateQuantity3() {
        quantityTextView3.text = quantity3.toString()
    }

    private fun updatePrice3() {
        val totalPrice3 = pricePerItem3 * quantity3
        priceTextView3.text = String.format("₱%.2f", totalPrice3)
    }

    private fun generateReceipt(): String {
        val totalPrice1 = pricePerItem1 * quantity1
        val totalPrice2 = pricePerItem2 * quantity2
        val totalPrice3 = pricePerItem3 * quantity3
        val grandTotal = totalPrice1 + totalPrice2 + totalPrice3

        val dateFormat = SimpleDateFormat("yyyy-MM-dd \n HH:mm:ss", Locale.getDefault())
        val currentDate = dateFormat.format(Date())

        val receipt = StringBuilder()
        receipt.append("Receipt:\n\n")
        receipt.append("Date: $currentDate\n\n")

        receipt.append("BLACK PEPPER BEEF\n")
        receipt.append("Quantity: $quantity1\n")
        receipt.append("Total: ₱${String.format("%.2f", totalPrice1)}\n\n")

        receipt.append("BACON CHEESE BURGER\n")
        receipt.append("Quantity: $quantity2\n")
        receipt.append("Total: ₱${String.format("%.2f", totalPrice2)}\n\n")

        receipt.append("CRISPY CHICKEN BURGER\n")
        receipt.append("Quantity: $quantity3\n")
        receipt.append("Total: ₱${String.format("%.2f", totalPrice3)}\n\n")

        receipt.append("Grand Total: ₱${String.format("%.2f", grandTotal)}")

        return receipt.toString()
    }
}