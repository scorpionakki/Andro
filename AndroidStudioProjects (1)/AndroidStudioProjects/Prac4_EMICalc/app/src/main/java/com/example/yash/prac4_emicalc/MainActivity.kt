package com.example.yash.prac4_emicalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcEMI(view: View) {
        val prin = findViewById<EditText>(R.id.prin_txt)
        val rate = findViewById<EditText>(R.id.rate_txt)
        val years = findViewById<EditText>(R.id.years_txt)
        val emitxt = findViewById<TextView>(R.id.emi_txt)

        val p = prin.text.toString().toDouble()
        val r = rate.text.toString().toDouble()
        val y = years.text.toString().toDouble()

        val interest = p * (r/100) * y
        val emi = (p + interest) /12

        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.CEILING
        val ans = "EMI: "+ (df.format(emi).toString())
        emitxt.text = ans
    }
}
