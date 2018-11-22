package com.example.yash.prac12_notifications

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun genNoti(view: View) {
        val ntfy = NotificationCompat.Builder(this)
        ntfy.setContentTitle("Reliance Jio")
        ntfy.setContentText("Low Balance")
        ntfy.setSmallIcon(R.mipmap.ic_launcher)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        ntfy.setSound(uri)
        ntfy.setAutoCancel(true)
        val `in` = Intent()
        //in.setClass(this,"")
        `in`.setClassName(
            " com.example.yash.prac12_notifications",
            " com.example.yash.prac12_notifications.Notification.this"
//            "com.mehta.dhaval.internal_storage_demo",
//            "com.mehta.dhaval.internal_storage_demo.Notification.this"
        )
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, `in`, PendingIntent.FLAG_UPDATE_CURRENT)
        ntfy.setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(666, ntfy.build())

    }
}
