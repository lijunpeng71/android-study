package com.cyinfo.android.study.activity

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.GridLayout
import com.cyinfo.android.study.R

class MainActivity : Activity() {

    private var chars = arrayOf(
        "7", "8", "9", "÷",
        "4", "5", "6", "x",
        "1", "2", "3", "-",
        ".", "0", "=", "+"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridLayout = findViewById<GridLayout>(R.id.root)
        for (i in chars.indices) {
            val button = Button(this)
            button.text = chars[i]
            button.textSize = 40F
            button.setPadding(5, 35, 5, 35)
            val rowSpec = GridLayout.spec(i / 4 + 2)
            val columnSpec = GridLayout.spec(i % 4)
            val params = GridLayout.LayoutParams(rowSpec, columnSpec)
            params.setGravity(Gravity.FILL)
            gridLayout.addView(button, params)
        }
    }
}
