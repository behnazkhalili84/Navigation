package com.example.navigationtutorial.ui.areacalc

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

class AreaCalc : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_area_calc, container, false)
        // Find views by their IDs
        // Find views by their IDs for the new layout
        val editTextWidth =view. findViewById<EditText>(R.id.editTextWidth)
        val editTextHeight = view.findViewById<EditText>(R.id.editTextHeight)
        val buttonCalculate =view. findViewById<Button>(R.id.buttonCalculate)
        val areaText =view. findViewById<EditText>(R.id.AreaText)
        val perimeterText =view. findViewById<EditText>(R.id.PerimeterText)



            buttonCalculate.setOnClickListener {
                val widthStr = editTextWidth.text.toString()
                val heightStr = editTextHeight.text.toString()

                if (widthStr.isEmpty() || heightStr.isEmpty()) {
                    Toast.makeText(context, "Please enter both width and height", Toast.LENGTH_SHORT).show()

                    return@setOnClickListener
                }

                val width = widthStr.toFloatOrNull()
                val height = heightStr.toFloatOrNull()

                if (width == null || height == null || width <= 0 || height <= 0) {
                    Toast.makeText(context, "Please enter valid width and height", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Calculate area and perimeter
                val area = width * height
                val perimeter = 2 * (width + height)

                areaText.setText(String.format("%.2f", area))
                perimeterText.setText(String.format("%.2f", perimeter))
            }


return view
    }
}