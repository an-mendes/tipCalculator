package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // important!!!
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializing binding variable
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {
        val toStringText = binding.costOfService.text.toString()
        val cost = toStringText.toDouble()
        val tipTotal: Double
        // simple if statement for calculating tip
        if (binding.optionTwenty.isChecked) {
            tipTotal = cost + (cost * 0.2)
        } else if (binding.optionEighteen.isChecked) {
            tipTotal = cost + (cost * 0.18)
        } else {
            tipTotal = cost + (cost * 0.15)
        }
        // this casting doesn't actually work, don't know why, need to fix
        val roundedTipTotal = tipTotal.toInt()
        if (binding.roundUpSwitch.isChecked) {
            val tipResultText = roundedTipTotal.toString()
            binding.tipResult.text = tipResultText
        } else {
            val tipResultText = tipTotal.toString()
            binding.tipResult.text = tipResultText
        }
    }
}