package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var currentNumber: Int = 0

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER_KEY", currentNumber)

        Log.d( "TAG1231415", "onSaveInstanceState")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.button_toast)
        val counterButton = findViewById<Button>(R.id.button_counter)
        val text = findViewById<TextView>(R.id.text_id)

        val persistedCounterNumber= savedInstanceState?.getInt("COUNTER_KEY")
        if (persistedCounterNumber != null) {
            currentNumber = persistedCounterNumber
            text.setText(currentNumber.toString())
        }



        toastButton.setOnClickListener {
            //Log.d( "TAG123123", "Toast Button Clicked")
            val toast = Toast.makeText(this,"A toast message is displayed", Toast.LENGTH_SHORT).show()
        }

        counterButton.setOnClickListener {
           // Log.d( "TAG123123", "Counter Button Clicked")
            currentNumber = currentNumber.inc()
            text.setText(currentNumber.toString())

        }
        Log.d( "TAG123123", "onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d( "TAG123456", "onStart")
    }



    override fun onResume() {
        super.onResume()
        Log.d( "TAG123789", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d( "TAG1231011", "onStop")
    }

        override fun onPause() {
            super.onPause()
            Log.d( "TAG1231213", "onPause")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d( "TAG1231415", "onDestroy")
        }


}



