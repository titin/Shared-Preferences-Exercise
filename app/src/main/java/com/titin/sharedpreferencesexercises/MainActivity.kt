package com.titin.sharedpreferencesexercises

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.titin.sharedpreferencesexercises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences(R.string.app_name.toString(), MODE_PRIVATE)
        binding.simpan.setOnClickListener {
            write(binding.inputan.text.toString())
            binding.result.text = read()
        }
    }

    fun write(values: String){
        prefs.edit().putString("input", values).apply()
    }

    fun read (): String {
        return prefs.getString("input", "").toString()
    }


}