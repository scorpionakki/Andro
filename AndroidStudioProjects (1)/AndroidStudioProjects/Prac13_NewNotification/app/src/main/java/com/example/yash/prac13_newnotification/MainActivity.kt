package com.example.yash.prac13_newnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    public fun createNotificationChannel(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Waddup"
            val descriptionText = "Alkesh Boi"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("10", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            var mBuilder = NotificationCompat.Builder(this, "10")
                .setSmallIcon(R.drawable.notification_icon_background)
                .setContentTitle("Waddup")
                .setContentText("Alkesh Boi")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(10, mBuilder.build())
            }
        }
        else
        {

        }
    }
}
