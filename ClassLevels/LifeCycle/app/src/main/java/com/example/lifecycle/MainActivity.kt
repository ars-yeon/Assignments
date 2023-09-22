package com.example.lifecycle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.lifecycle.Constants.main
import com.example.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d(main, "onCreate called")

        val btnSub = binding.btnSubActivity
        val btnFrag = binding.btnFirstFragment
        val btnToastShort = binding.btnToastShort
        val btnToastLong = binding.btnToastLong

        btnSub.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        btnFrag.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, FirstFragment())
                addToBackStack(null)
            }
        }

        btnToastShort.setOnClickListener {
            Toast("This is Toast Message.")

        }
        btnToastLong.setOnClickListener {
            Toast("This Toast Message will be displayed for a longer time.", Toast.LENGTH_LONG)
        }
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

    private fun Context.Toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}