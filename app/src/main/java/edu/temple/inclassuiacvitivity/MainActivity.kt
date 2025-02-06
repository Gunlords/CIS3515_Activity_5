package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // Step 1: Populate this array with text sizes (increments of 2)
        val numberArray = List(50) { i -> (i + 1) * 2 }

        with(spinner) {
            // Step 2: Use custom TextSizeAdapter instead of ArrayAdapter
            adapter = TextSizeAdapter(this@MainActivity, numberArray)

            // Step 3: Change TextView's text size to the selected number
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    displayTextView.textSize = numberArray[position].toFloat()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }
}
