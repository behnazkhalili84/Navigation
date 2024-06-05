package com.example.navigationtutorial.ui.bmicalc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity.INPUT_METHOD_SERVICE
import androidx.core.view.isInvisible
import com.example.navigationtutorial.R

class BMI : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_b_m_i, container, false)
        // Find views by their IDs
        val editTextWeight = view.findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight = view.findViewById<EditText>(R.id.editTextHeight)
        val buttonCalculateBmi =view. findViewById<Button>(R.id.buttonCalculateBmi)
        val editTextBmiResult = view.findViewById<EditText>(R.id.editTextBmiResult)
        val textViewBmiCategory =view. findViewById<TextView>(R.id.textViewBmiCategory)

        // Set OnClickListener for the button
        buttonCalculateBmi.setOnClickListener {
            val weightStr = editTextWeight.text.toString()
            val heightStr = editTextHeight.text.toString()

            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Toast.makeText(context, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = weightStr.toFloatOrNull()
            val height = heightStr.toFloatOrNull()

            if (weight == null || height == null || weight <= 0.1 || weight > 400 || height <= 0.15 || height > 2.6) {
                Toast.makeText(context, "Please enter valid weight (0.1-400 kg) and height (0.15-2.6 m)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calculate BMI
            val bmi = weight / (height * height)
            editTextBmiResult.setText(String.format("%.2f", bmi))

            // Determine BMI category
            val bmiCategory = when {
                bmi < 15 -> "Very severely underweight"
                bmi < 16 -> "Severely underweight"
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal weight"
                bmi < 29.9 -> "Overweight"
                bmi < 34.9 -> "Obesity class I (Moderately obese)"
                bmi < 39.9 -> "Obesity class II (Severely obese)"
                else -> "Obesity class III (Very severely obese)"
            }
            textViewBmiCategory.text = "BMI Category: $bmiCategory"
            textViewBmiCategory.isInvisible = false
        }

        return view

    }
}