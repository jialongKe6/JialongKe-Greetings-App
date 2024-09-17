package com.example.greetings

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Calendar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val greetButton: Button = findViewById(R.id.greetButton)
        val greetingTextView: TextView = findViewById(R.id.greetingTextView)

        initializeTextView(greetingTextView)

        greetButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            greetingTextView.text = if (name.isNotEmpty()) {
                generateGreetingMessage(name)
            } else {
                "Please enter your name!"
            }
        }
    }

    private fun initializeTextView(textView: TextView) {
        textView.apply {
            textSize = 24f
            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        }
    }

    private fun generateGreetingMessage(name: String): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val timeOfDay = when (hour) {
            in 0..5 -> "Good night"
            in 6..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            else -> "Good evening"
        }
        return "Hello $name! $timeOfDay!"
    }
}
