package com.example.yash.prac10_storage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun majaAyega(view: View){
        val file = File(filesDir, "ganduBoisStorage")
        file.writeText(file.readText()+txt1.text.toString())
    }

    fun majaNahiAyega(view: View){
        val directory = filesDir
        val file = File(directory, "ganduBoisStorage")
        val readText = file.readText()
        textView.text = readText
//        textView.text=file.absolutePath

    }
}
