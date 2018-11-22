package com.example.yash.prac11_externalstorage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.provider.MediaStore
import android.content.Intent
import android.graphics.Bitmap





class MainActivity : AppCompatActivity() {
    var iv1: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv1 = findViewById(R.id.imageView)
    }

    fun takePhoto(view: View)
    {
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it, 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val b = data!!.extras!!.get("data") as Bitmap

        iv1!!.setImageBitmap(b)
        MediaStore.Images.Media.insertImage(contentResolver, b, "FD", "DF")

    }
}
