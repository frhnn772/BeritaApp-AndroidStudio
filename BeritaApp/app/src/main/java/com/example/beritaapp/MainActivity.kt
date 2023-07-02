package com.example.beritaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beritaapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        adapter = RVAdapter((arrayListOf()),this@MainActivity)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = adapter
        getBeritas()
    }

    fun getBeritas(){
        RClient.rService.getBerita().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call:Call<ResponseModel>,response:Response<ResponseModel>){
                if (response.isSuccessful){
                    val data = response.body()
                    if (data!=null){
                        setData(data.listberita)
                    }
                }
            }
            override fun onFailure(call:Call<ResponseModel>,t:Throwable){
                Log.d("Error Get",""+t.stackTraceToString())
            }
        })
    }
    fun  setData(data:ArrayList<ResponseModel.Beritas>){
        adapter.setData(data)
    }
}