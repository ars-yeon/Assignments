package com.example.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycle.Constants.frag

class FirstFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(frag, "onCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(frag, "onCreateView called")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(frag, "onViewCreated called")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(frag, "onViewStateRestored called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(frag, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(frag, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(frag, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(frag, "onStop called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(frag, "onSaveInstanceState called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(frag, "onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(frag, "onDestroy called")
    }
}