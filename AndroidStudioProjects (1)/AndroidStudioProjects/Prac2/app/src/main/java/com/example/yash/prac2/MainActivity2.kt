package com.example.yash.prac2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button2: Button = findViewById(R.id.btn_exit2)
        val button1: Button = findViewById(R.id.btn_activity1)
        button1.setOnClickListener {
            val i = Intent(this, MainActivity1::class.java)
            startActivity(i)
        }
        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity2)
            builder.setMessage("Are you sure to Exit?")
                    .setPositiveButton("YES") { _, _ -> System.exit(0) }
                    .setNegativeButton("No") { _, _ ->
                        // User cancelled the dialog
                    }
            builder.show()
        }
    }
}
