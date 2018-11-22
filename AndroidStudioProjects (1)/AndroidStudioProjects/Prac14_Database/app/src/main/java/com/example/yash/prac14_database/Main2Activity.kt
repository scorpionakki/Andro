package com.example.yash.prac14_database

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList
import android.database.sqlite.SQLiteDatabase




class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var lv = findViewById<ListView>(R.id.l1)
        var myDatabase = myDB(this)


        var db = myDatabase.getWritableDatabase()
        val squery = "Select * from emp"
        val cursor = db.rawQuery(squery, null)
        val mylist = ArrayList<String>()

        while (cursor.moveToNext()) {
            val n1 = cursor.getString(1)
            mylist.add(n1)

        }
        //Access Program Array
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mylist)
        // ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,months);
        lv.adapter = adapter
        lv.setOnItemClickListener { _, _, position, _ ->
            var item: String = lv.getItemAtPosition(position).toString()

            Toast.makeText(baseContext, "You Clicked $item", Toast.LENGTH_SHORT).show()
        }


    }
}
