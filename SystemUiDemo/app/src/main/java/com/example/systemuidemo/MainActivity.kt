package com.example.systemuidemo

import android.os.Bundle
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toggleButton = findViewById<ToggleButton>(R.id.fullscreen_btn)
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // フルスクリーンにする
                showSystemUI()
            } else {
                // フルスクリーンを解除する
                hideSystemUI()
            }
        }
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, window.decorView).also {
            it.show(
                WindowInsetsCompat.Type.systemBars().or(WindowInsetsCompat.Type.navigationBars())
            )
            it.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).also {
            it.hide(
                WindowInsetsCompat.Type.systemBars().or(WindowInsetsCompat.Type.navigationBars())
            )
            it.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}