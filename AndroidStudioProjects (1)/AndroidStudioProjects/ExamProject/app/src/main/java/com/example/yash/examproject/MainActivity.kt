package com.example.yash.examproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import android.support.v7.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var stubal = 0
    var stuName = ""
    var stuID = 0
    var builder: AlertDialog.Builder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verifyStud(view: View){
        var stu_id = findViewById<EditText>(R.id.vrfyID)
        var stu_id_int = stu_id.text.toString().toInt()
        stuID = stu_id_int

        if(stu_id_int <= 0)
        {
            textView5.visibility = View.VISIBLE
            finalMsg.visibility = View.VISIBLE
            finalMsg.text = "Please Enter A Valid ID"
        }
        else
        {
            var showname = findViewById<TextView>(R.id.payeeName)
            val url = "http://192.168.43.112/ExamUserVerificationScript.php?id=$stu_id_int"

            //Toast.makeText(this,url, Toast.LENGTH_SHORT).show()

            val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> { response ->
                var response = response
                try {
                    response = response.getJSONObject("student")
                    val sname = response.getString("sname")
                    val sbal = response.getString("sbal")
                    if(sname == "0") {
                        textView5.visibility = View.VISIBLE
                        finalMsg.visibility = View.VISIBLE
                        finalMsg.text = "Student Not found"
                    }
                    else
                    {
                        stuName = sname
                        textView3.visibility = View.VISIBLE
                        button3.visibility = View.VISIBLE
                        showname.visibility= View.VISIBLE
                        textView5.visibility = View.VISIBLE
                        finalMsg.visibility = View.VISIBLE
                        stubal = sbal.toInt()
                        textView3.text = "Welcome $stuName"
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    textView5.visibility = View.VISIBLE
                    finalMsg.visibility = View.VISIBLE
                    finalMsg.text = error.message
                }
            })

            Volley.newRequestQueue(this@MainActivity).add(jsonRequest)
        }
    }

    fun TransFerAmt (view: View){
        val trnfrAmt = findViewById<EditText>(R.id.payeeName)
        val trnfrAmtInt = trnfrAmt.text.toString().toInt()

        if(trnfrAmtInt > stubal)
        {
            textView5.visibility = View.VISIBLE
            finalMsg.visibility = View.VISIBLE
            finalMsg.text = "Tranfer Amount Greater than account Balance!"
        }
        else
        {
            val url = "http://192.168.43.112/ExamTransactionScript.php?id=$stuID&amt=$trnfrAmtInt"
            val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> { response ->
                var response = response
                try {
                    response = response.getJSONObject("student")
                    val sname = response.getString("status")
                    if (sname == "1")
                    {
                        stubal = stubal-trnfrAmtInt
                        finalMsg.text = "Funds Transferred Successfully!"
                    }
                    else if(sname == "0")
                    {
                        finalMsg.text = "Please Provide all the inputs"
                    }
                    else
                    {
                        finalMsg.text = "Error Processing Transaction, Please try again with valid inputs!"
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    textView5.visibility = View.VISIBLE
                    finalMsg.visibility = View.VISIBLE
                    finalMsg.text = error.message
                }
            })
            Volley.newRequestQueue(this@MainActivity).add(jsonRequest)
        }
    }

    override fun onBackPressed() {
        this.builder!!.setMessage("Are You Sure to Exit").setTitle("NUV")

        this.builder!!.setPositiveButton("OK") { _, id -> System.exit(0) }
        builder!!.setNegativeButton("CANCEL") { _, id ->
            // User cancelled the dialog
        }

        builder!!.show()

    }
}
