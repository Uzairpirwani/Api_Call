package com.example.apicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ApiAdapter
    lateinit var apilist:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApi()
    }

    private fun getApi() {
        val api = ApiService.apiInstance.getdetail(1)
        api.enqueue(object : retrofit2.Callback<Detail>{

            override fun onFailure(call: Call<Detail>, t: Throwable) {
                Log.d("uzair", "Error in Fetching Api", t)}

                override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                val api = response.body()
                if (api != null){
                    Log.d("Uzair", api.toString())
                    adapter = ApiAdapter(this@MainActivity,api.informations)
                    apilist = findViewById(R.id.apiCall)
                    apilist.adapter = adapter
                    apilist.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }




        })
    }
}