package com.example.yash.prac2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        val button2: Button = findViewById(R.id.btn_exit)
        val button1: Button = findViewById(R.id.btn_activity2)
        button1.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
        button2.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity1)
            builder.setMessage("Are you sure to Exit?")
                    .setPositiveButton("YES") { _, _ -> System.exit(0) }
                    .setNegativeButton("No") { _, _ ->
                        // User cancelled the dialog
                    }
            builder.show()
        }
    }
}
