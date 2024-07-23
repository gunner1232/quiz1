package com.example.quiz1
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.btResult1)
        val subtractButton: Button = findViewById(R.id.btResult2)
        val multiplyButton: Button = findViewById(R.id.btResult3)
        val divideButton: Button = findViewById(R.id.btResult4)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)

        val clickListener = View.OnClickListener { view ->
            val x = edtxt1.text.toString().toDoubleOrNull()
            val y = edtxt2.text.toString().toDoubleOrNull()

            if (x != null && y != null) {
                val result = when (view.id) {
                    R.id.btResult1 -> x + y
                    R.id.btResult2 -> x - y
                    R.id.btResult3 -> x * y
                    R.id.btResult4 -> if (y != 0.0) x / y else null
                    else -> null
                }
                resultTV.text = result?.toString() ?: "The divisor cannot be 0"
            } else {
                resultTV.text = "Please enter a valid number"
            }
        }

        addButton.setOnClickListener(clickListener)
        subtractButton.setOnClickListener(clickListener)
        multiplyButton.setOnClickListener(clickListener)
        divideButton.setOnClickListener(clickListener)
    }
}