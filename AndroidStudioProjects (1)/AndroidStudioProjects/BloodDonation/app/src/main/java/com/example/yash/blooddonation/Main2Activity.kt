package com.example.yash.blooddonation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.annotation.NonNull
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun signOut(v: View) {
        if (v.getId() === R.id.button2) {
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(object : OnCompleteListener<Void> {
                    override fun onComplete(task: Task<Void>) {
                        // user is now signed out
                        startActivity(Intent(this@Main2Activity, MainActivity::class.java))
                        finish()
                    }
                })
        }
        Toast.makeText(this,"Not in IF", Toast.LENGTH_LONG)
    }
}
