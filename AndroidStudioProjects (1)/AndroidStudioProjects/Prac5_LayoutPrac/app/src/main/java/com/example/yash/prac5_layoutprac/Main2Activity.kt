package com.example.yash.prac5_layoutprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.webkit.WebView
import android.widget.EditText


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val myWebView = findViewById<WebView>(R.id.webvw)
        myWebView.webViewClient = WebViewClient()
        val webSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        myWebView.loadUrl("https://www.google.co.in/")


        //myWebView.loadData("<html><body><span style='color:red'>Hello, world!</span></body></html>","text/html", "UTF-8");
    }

    fun LoadPage(view: View)
    {
        val urlr = findViewById<EditText>(R.id.editUrl)
        val url = urlr.text.toString()

        val myWebView = findViewById<WebView>(R.id.webvw)
        myWebView.webViewClient = WebViewClient()
        val webSettings = myWebView.settings
        webSettings.javaScriptEnabled = true

        myWebView.loadUrl("http://$url")
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            return false
        }
    }
}
