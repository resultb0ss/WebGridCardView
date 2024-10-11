package com.example.webgridcardview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webgridcardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf(
        GridViewModal("Музыка",R.drawable.ymusic,
            "https://music.yandex.ru/"),
        GridViewModal("Видео",R.drawable.yvideo,
            "https://ya.ru/video/"),
        GridViewModal("Авто",R.drawable.yauto,
            "https://auto.ru/"),
        GridViewModal("Карты",R.drawable.ymaps,
            "https://yandex.ru/maps"),
        GridViewModal("Метро",R.drawable.ymetro,
            "https://yandex.ru/metro"),
        GridViewModal("Маркет",R.drawable.ymarket,
            "https://market.yandex.ru/"),
        GridViewModal("Переводчик",R.drawable.ytranslate,
            "https://translate.yandex.ru/"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GridViewAdapter(list = list, this@MainActivity)
        binding.mainGridView.adapter = adapter

        binding.mainGridView.onItemClickListener = AdapterView.OnItemClickListener{_,_,position,_ ->
            val url = list[position].url
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            Toast.makeText(applicationContext,"Выбран элемент ${list[position].name}",
                Toast.LENGTH_SHORT).show()
        }

        binding.secondActivityExitButtonBTN.setOnClickListener {
            this.finishAffinity()
        }

    }
}