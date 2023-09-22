package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lifecycle.Constants.sub
import com.example.lifecycle.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d(sub, "onCreate called")

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }
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