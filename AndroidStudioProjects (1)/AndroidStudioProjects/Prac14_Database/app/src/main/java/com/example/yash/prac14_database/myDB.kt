package com.example.yash.prac14_database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Created by Administrator on 11/2/2017.
 */

public class myDB(internal var mt: Context) /* 1 Class Parameter 2 DB Name 3 Searching Record 4 Verson of Database*/ :
    SQLiteOpenHelper(mt, "Records.db", null, 1) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val tq = "CREATE TABLE EMP(ID INTEGER PRIMARY KEY AUTOINCREMENT,MYNAME TEXT,AGE NUMBER,ADDRESS TEXT)"
        sqLiteDatabase.execSQL(tq)
        Toast.makeText(mt, "Database Created", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {

    }
}
