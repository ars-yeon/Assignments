package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycle.Constants.sub

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        Log.d(sub, "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(sub, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(sub, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(sub, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(sub, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(sub, "onDestroy called")
    }
}