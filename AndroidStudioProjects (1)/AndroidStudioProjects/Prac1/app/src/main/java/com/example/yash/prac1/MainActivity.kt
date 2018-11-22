package com.example.yash.prac1
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.yash.prac1.R.id
import com.example.yash.prac1.R.layout

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val button2:Button = findViewById(id.minus_btn)
        val button1:Button = findViewById(id.plus_btn)
        var i = 0
        val t1:TextView = findViewById(id.txt_counter)
        button1.setOnClickListener {
            i = Integer.parseInt(t1.text.toString())
            i += 1
            t1.text = i.toString()
            button2.isEnabled = true
        }
        button2.isEnabled = i != 0
        button2.setOnClickListener {
            i = Integer.parseInt(t1.text.toString())
            i -= 1
            t1.text = i.toString()
        }
    }
}