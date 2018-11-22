package com.example.yash.prac15_audiovideo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.song)

        button.setOnClickListener {
            Toast.makeText(applicationContext, "Play", Toast.LENGTH_SHORT).show()
            mediaPlayer.start() // no need to call prepare(); create() does that for you
        }
        button2.setOnClickListener {
            Toast.makeText(applicationContext, "Pause", Toast.LENGTH_SHORT).show()
            mediaPlayer.pause()
        }
        button3.setOnClickListener {
            Toast.makeText(applicationContext, "Stop", Toast.LENGTH_SHORT).show()
            mediaPlayer.stop()
        }

    }
}
