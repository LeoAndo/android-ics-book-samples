package com.example.listpopupwindowdemo

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showpopup = findViewById<Button>(R.id.showpopup)
        val showpopup2 = findViewById<Button>(R.id.showpopup2)

        // Adapter を用意
        val data = arrayOf("data1", "data2", "data3", "data4")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        // ListPopupWindow を生成
        val lpw = ListPopupWindow(this)
        val lpw2 = ListPopupWindow(this)
        // Adapter をセット
        lpw.setAdapter(adapter)
        lpw2.setAdapter(adapter)
        // ポップアップを表示する位置の水平方向のオフセット
        lpw2.horizontalOffset = 20
        // ポップアップを表示する位置の垂直方向のオフセット
        lpw2.verticalOffset = 20
        // グラデーションの drawable を生成
        val d = GradientDrawable(
            GradientDrawable.Orientation.BR_TL,
            intArrayOf(Color.RED, Color.YELLOW)
        )
        // 背景画像をセット
        lpw2.setBackgroundDrawable(d)
        // プロンプトビューを用意
        val iv = ImageView(this)
        iv.setImageResource(R.drawable.ic_launcher_foreground)
        // プロンプトビューをセット
        lpw2.setPromptView(iv)
        // プロンプトビューの位置をセット
        lpw2.promptPosition = ListPopupWindow.POSITION_PROMPT_ABOVE
        // アンカービューをセット
        lpw.anchorView = showpopup
        lpw2.anchorView = showpopup2


        // リストのアイテムがタップされたときのリスナーをセット
        lpw.setOnItemClickListener { parent, _, position, _ ->
            val s = parent.getItemAtPosition(position) as? String ?: ""
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
            lpw.dismiss()
        }
        lpw2.setOnItemClickListener { parent, _, position, _ ->
            val s = parent.getItemAtPosition(position) as? String ?: ""
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
            lpw2.dismiss()
        }


        // ボタンのクリックイベントの処理
        findViewById<Button>(R.id.showpopup).setOnClickListener { lpw.show() }
        findViewById<Button>(R.id.showpopup2).setOnClickListener { lpw2.show() }
    }
}