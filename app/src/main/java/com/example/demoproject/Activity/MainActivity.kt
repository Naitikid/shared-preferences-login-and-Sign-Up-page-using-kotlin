package com.example.demoproject.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns

import com.example.demoproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        finish()
    }

    private fun initView() {


    }


}
