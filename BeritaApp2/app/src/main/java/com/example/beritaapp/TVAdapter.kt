package com.example.beritaapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beritaapp.databinding.ItemsMainBinding

class RVAdapter(private val datas: ArrayList<ResponseModel.Beritas>, val ctx: Context):
    RecyclerView.Adapter<RVAdapter.MyViewHolder>(){
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemsMainBinding.bind(view)
        val tvJudul = binding.tvJudul
        val tvKreator = binding.tvKreator
        val tvCreated = binding.tvCreatedAt
        val ivMain = binding.ivMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_main, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvJudul.text = datas[position].judul_berita
        holder.tvKreator.text = datas[position].kreator
        holder.tvCreated.text = datas[position].created_at
        Glide.with(holder.itemView.context)
            .load("https://farhanmulyaputra-2510.herokuapp.com/"+datas[position].gambar_berita)
            .circleCrop()
            .into(holder.ivMain)
        holder.itemView.setOnClickListener {
                v ->
            val intent = Intent(v.context, BeritaActivity::class.java)
            intent.putExtra("kreator", datas[position].kreator)
            intent.putExtra("judul", datas[position].judul_berita)
            intent.putExtra("berita", datas[position].isi_berita)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = datas.size
    fun setData(data: ArrayList<ResponseModel.Beritas>){
        datas.clear()
        datas.addAll( data )
        notifyDataSetChanged()
    }

}