package com.cyinfo.android.study

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private var images =
        intArrayOf(R.drawable.java, R.drawable.javaee, R.drawable.swift, R.drawable.ajax, R.drawable.html)
    private var currentImg = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var main = findViewById<LinearLayout>(R.id.root)
        var image = ImageView(this)
        main.addView(image)
        image.setImageResource(images[0])
        image.setOnClickListener {
            image.setImageResource(images[++currentImg % images.size])
        }
    }
}
