package com.example.beritaapp

data class ResponseModel(val listberita: ArrayList<Beritas>,) {
    data class  Beritas(
            val id:Int,
            val judul_berita: String,
            val kreator:String,
            val isi_berita:String,
            val gambar_berita:String,
            val slug:String,
            val created_at:String,
    )
}