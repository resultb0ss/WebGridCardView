package com.example.webgridcardview

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webgridcardview.databinding.ActivityBrowserBinding

class BrowserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBrowserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webViewWV.webViewClient = WebViewClient()
        val data = intent.data
        binding.webViewWV.loadUrl(data.toString())

    }
}