package com.example.yash.prac16_video

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView = findViewById<View>(R.id.videoView) as VideoView

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of media file

        val uri = Uri.parse("https://www.w3schools.com/html/movie.mp4")

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}
