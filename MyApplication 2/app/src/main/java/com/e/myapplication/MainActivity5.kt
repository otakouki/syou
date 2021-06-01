package com.e.myapplication

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val webView = findViewById(R.id.webview) as WebView
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                android.util.Log.d("MainActivity", url.toString())
                view?.loadUrl(url.toString())
                return true
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler,
                error: SslError?
            ) {
                android.util.Log.d("MainActivity", error.toString())
                handler.proceed() // Ignore SSL certificate errors
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("http://syou.sakura.ne.jp/minsyumi_qa_top.php")
    }


}