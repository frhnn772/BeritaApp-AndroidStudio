package com.example.beritaapp

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beritaapp.databinding.ActivityBeritaBinding


class BeritaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBeritaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeritaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val kreator = intent.getStringExtra("kreator").toString()
        val judul = intent.getStringExtra("judul").toString()
        val berita = intent.getStringExtra("berita").toString()
        val create = intent.getStringExtra("create").toString()
        val gambar_berita = intent.getStringExtra("gambar").toString()

        binding.tvKreator.text = kreator
        binding.tvJudul.text = judul

        binding.tvBerita.text = Html.fromHtml(berita)

        Glide.with(binding.ivBerita)
            .load("https://farhanmulyaputra-2510.herokuapp.com/"+gambar_berita)
            .into(binding.ivBerita)

    }
}