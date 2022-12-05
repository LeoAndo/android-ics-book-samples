package com.example.popupmenudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.showpopup).setOnClickListener {
            PopupMenu(this, it).apply {
                inflate(R.menu.menu)
                setOnMenuItemClickListener {
                    // メニュー項目がタップされたときに呼ばれる: false指定でイベントを消化しない
                    false
                }
                show()
            }
        }
        findViewById<Button>(R.id.showpopup2).setOnClickListener {
            PopupMenu(this, it).apply {
                inflate(R.menu.menu)
                setOnMenuItemClickListener {
                    false
                }
                show()
            }
        }
    }
}