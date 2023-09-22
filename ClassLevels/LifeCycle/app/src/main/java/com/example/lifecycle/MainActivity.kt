package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycle.Constants.main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(main, "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(main, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(main, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(main, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(main, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(main, "onDestroy called")
    }
}