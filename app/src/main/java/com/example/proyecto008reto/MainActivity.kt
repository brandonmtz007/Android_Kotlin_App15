package com.example.proyecto008reto

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var button4: Button

    private val button: Button by lazy {
        findViewById<Button>(R.id.button)
    }
    private val boton: Button by lazy {
        findViewById<Button>(R.id.button2)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "Diste click para el snackbar!",
                Snackbar.LENGTH_SHORT
            )
            snackbar.show()
        }

        boton.setOnClickListener {
            val toast = Toast.makeText(this, "¡Diste click para el toast!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
                toast.show()
        }

        // Initialize button3 and set OnClickListener
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            // Get the current time
            val currentTime = getCurrentTime()

            // Show the current time in a Toast
            Toast.makeText(this, "Son las: $currentTime", Toast.LENGTH_SHORT).show()
        }
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        button4 = findViewById(R.id.button4)

        button4.setOnClickListener {
            // Get the values from the EditText fields
            val num1Str = et1.text.toString()
            val num2Str = et2.text.toString()

            if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
                // Convert the input to numbers
                val num1 = num1Str.toDouble()
                val num2 = num2Str.toDouble()

                // Perform the calculation
                val sum = num1 + num2

                // Display the result in a Snackbar
                val snackbarText = "Suma = $sum"
                val snackbarDuration = Snackbar.LENGTH_SHORT
                val rootView = findViewById<View>(android.R.id.content)
                val snackbar = Snackbar.make(rootView, snackbarText, snackbarDuration)
                snackbar.show()
            } else {
                // Display an error message in a Snackbar
                val snackbarText = "Please enter both numbers"
                val snackbarDuration = Snackbar.LENGTH_SHORT
                val rootView = findViewById<View>(android.R.id.content)
                val snackbar = Snackbar.make(rootView, snackbarText, snackbarDuration)
                snackbar.show()
            }
        }
    }

    // Function to get the current time as a string
    private fun getCurrentTime(): String {
        val currentTimeMillis = System.currentTimeMillis()
        val currentTime = java.text.SimpleDateFormat("HH:mm:ss", java.util.Locale.getDefault()).format(currentTimeMillis)
        return currentTime
    }
}
