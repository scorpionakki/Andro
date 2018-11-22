package com.example.yash.prac14_database

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


class MainActivity : AppCompatActivity() {
    var myDatabase: myDB? = null
    var myname: String? = null
    var myadd:String? = null
    var myage: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myDatabase = myDB(this);
    }

    fun saveData(view: View){
        myname = txtName.text.toString()
        myage = txtAge.text.toString()
        myadd = txtCity.text.toString()
        var db = myDatabase!!.getWritableDatabase()
        val insquery = "INSERT INTO EMP(MYNAME,AGE,ADDRESS)VALUES('$myname', $myage,'$myadd')"
        db.execSQL(insquery)
        Toast.makeText(this, "Record Added", Toast.LENGTH_SHORT).show()
        txtName.text.clear()
        txtAge.text.clear()
        txtCity.text.clear()
    }

    fun viewdata(view: View) {
        var db = myDatabase!!.getWritableDatabase()
        val squery = "Select * from emp"
        val cursor = db.rawQuery(squery, null)

        while (cursor.moveToNext()) {
            val n1 = cursor.getString(1)
            val n2 = cursor.getInt(2)
            val n3 = cursor.getString(3)
            Toast.makeText(this, "Name : $n1\nAge : $n2\nAddress : $n3", Toast.LENGTH_SHORT).show()
        }
    }

    fun viewall(view: View) {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

}
