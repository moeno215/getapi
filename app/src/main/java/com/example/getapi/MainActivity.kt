package com.example.getapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fetchJson()

    }

    fun fetchJson() {
        println("Attempting to Fetch JSON")
        val url = "http://www.wahanaartha.com/PRJeventunit2018/MobileSpkPrjs/getMotors"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)



    }
}

            override fun onFailure(call: okhttp3.Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}

class HomeFeed(var status: Int? = 0, var message: String? = null,var motors: List<MotorsItem>? = null)

class MotorsItem(var id: String? = null, var name: String? = null, var harga_jual: String? = null, var motor_category_id: String? = null,
            var thn_motor: String? = null)

