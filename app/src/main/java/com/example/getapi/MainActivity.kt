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

class HomeFeed(val motors: List<MotorsItem>)

class MotorsItem(val getMotorCategoryId: String, val getName: String, val getThnMotor: String, val getId: String,
            val getHargaJual: String)

