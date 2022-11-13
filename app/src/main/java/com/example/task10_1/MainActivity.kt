package com.example.task10_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.task10_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bAdd.setOnClickListener {

            val navHost = Navigation.findNavController(this, R.id.nav_host_fragment)

            navHost.navigate(R.id.action_listFragment_to_createFragment)
        }
    }
}