package com.project.olol.presentation.ui.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.project.olol.R

class TosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tos)

        val webView = findViewById<WebView>(R.id.webview)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = false
        webView.loadUrl("https://efficacious-ease-5ad.notion.site/1284f19e53cc801b809ef0554fcd9f3b?pvs=4")
    }
}