package com.example.baitap01

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.*
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val imageAvatar = findViewById<CircleImageView>(R.id.imageAvatar)
        val textUserName = findViewById<TextView>(R.id.textViewName)
        val textInfo = findViewById<TextView>(R.id.info)
        val editTextNumbers = findViewById<TextView>(R.id.editTextNumber)
        val buttonNumberProcess = findViewById<Button>(R.id.buttonNumberProcess)
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonProcess = findViewById<Button>(R.id.buttonProcess)
        val textViewOutput = findViewById<TextView>(R.id.textViewOutput)

        imageAvatar.setImageResource(R.drawable.profile)
        textUserName
        textInfo

        buttonNumberProcess.setOnClickListener {
            val input = editTextNumbers.text.toString().trim()
            if (input.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập mảng số!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val numbers = input.split(",", " ", ";")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }

                val evenNumbers = numbers.filter { it % 2 == 0 }
                val oddNumbers = numbers.filter { it % 2 != 0 }

                Log.d("EvenNumbers", evenNumbers.joinToString(", "))
                Log.d("OddNumbers", oddNumbers.joinToString(", "))

                Toast.makeText(this, "Đã in kết quả ra Logcat", Toast.LENGTH_SHORT).show()

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Dữ liệu không hợp lệ! Hãy nhập toàn số.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        buttonProcess.setOnClickListener {
            val input = editTextInput.text.toString()

            if (input.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            textViewOutput.text = input

            val reversed = input
                .trim()
                .split(" ")
                .filter { it.isNotEmpty() }
                .reversed()
                .joinToString(" ")
                .uppercase()

            textViewOutput.text = "$reversed"
        }
        supportActionBar?.hide()
    }
}