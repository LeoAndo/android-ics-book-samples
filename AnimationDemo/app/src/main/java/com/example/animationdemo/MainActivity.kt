package com.example.animationdemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.ALPHA, 1f, 0f, 1f).apply {
                duration = DURATION
            }.start()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.TRANSLATION_X, 0f, 100f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.TRANSLATION_Y, 0f, 100f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.ROTATION, 0f, 360f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.ROTATION_X, 0f, 360f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.ROTATION_Y, 0f, 360f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.SCALE_X, 1f, 2f, 1f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.SCALE_Y, 1f, 2f, 1f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button9).setOnClickListener {
            ObjectAnimator.ofPropertyValuesHolder(
                it,
                PropertyValuesHolder.ofFloat("pivotX", 0f, 200f),
                PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 2f, 1f)
            ).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button10).setOnClickListener {
            ObjectAnimator.ofPropertyValuesHolder(
                it,
                PropertyValuesHolder.ofFloat("pivotY", 0f, 200f),
                PropertyValuesHolder.ofFloat(View.ROTATION, 0f, 360f)
            ).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button11).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.X, 0f, 200f).apply {
                duration = DURATION
            }.start()
        }
        findViewById<Button>(R.id.button12).setOnClickListener {
            ObjectAnimator.ofFloat(it, View.Y, 0f, 200f).apply {
                duration = DURATION
            }.start()
        }
    }

    companion object {
        const val DURATION = 5000L
    }
}