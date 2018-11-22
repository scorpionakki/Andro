package com.example.yash.prac9_menu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class ContactUS : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.uni_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.home -> {
                Home()
                true
            }
            R.id.about_us -> {
                abUS()
                true
            }
            R.id.contact_us -> {
                conUS()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun Home()
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun abUS()
    {
        val intent = Intent(this, AboutUS::class.java)
        startActivity(intent)
    }

    fun conUS()
    {
        val intent = Intent(this, ContactUS()::class.java)
        startActivity(intent)
    }
}
