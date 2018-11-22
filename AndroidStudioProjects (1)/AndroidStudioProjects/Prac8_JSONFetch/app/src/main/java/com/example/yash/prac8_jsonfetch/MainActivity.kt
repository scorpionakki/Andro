package com.example.yash.prac8_jsonfetch

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {



    var builder: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tid = findViewById(R.id.txt_id) as TextView
        //tsname = findViewById(R.id.txt_name) as TextView
        builder = AlertDialog.Builder(this)
        builder!!.setMessage("Are You Sure to Exit").setTitle("NUV")

        builder!!.create()

    }

    fun loaddata(view:View) {
        var tid= findViewById<EditText>(R.id.editID)


        val id = tid.text.toString().toInt();

        if (id <= 0) {
            Toast.makeText(this, "Please enter a valid Id to search", Toast.LENGTH_SHORT).show()
        } else {



            var tsname =  findViewById<TextView>(R.id.txtName)
            var tsclass=findViewById<TextView>(R.id.txtClass)

            val url = ""


            val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener<JSONObject> { response ->
                var response = response
                // the response is already constructed as a JSONObject!
                try {
//                    response = response.getJSONObject("student")
//                    val sname = response.getString("sname")
//                    val cname = response.getString("cname")
                    val sname = response.getString("name")
                    val cname = response.getString("year")
                    if(sname == "0")
                    {
                        tsname.text = "Record Not Found"
                        tsclass.visibility = View.INVISIBLE
                    }
                    else if(sname == "-1")
                    {
                        tsname.text = "Not using GET method"
                        tsclass.visibility = View.INVISIBLE
                    }
                    else if(sname == "-2")
                    {
                        tsname.text = "Error in Parameter"
                        tsclass.visibility = View.INVISIBLE
                    }
                    else
                    {
                        tsclass.visibility= View.VISIBLE
                        tsname.text = sname
                        tsclass.text = cname
                    }

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, object : Response.ErrorListener {

                override fun onErrorResponse(error: VolleyError) {
                    builder!!.setMessage(error.message).setTitle("NUV")
                    builder!!.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> })


                    builder!!.show()
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
