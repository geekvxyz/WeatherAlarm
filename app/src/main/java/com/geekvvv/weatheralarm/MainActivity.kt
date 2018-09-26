package com.geekvvv.weatheralarm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.geekvvv.weatheralarm.http.HttpClient
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val client = HttpClient.getInstance().httpClient
    private var textview: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview = findViewById(R.id.text)
        run()
    }

    fun run() {
        val request = Request.Builder()
                .url("http://product.weather.com.cn/alarm/grepalarm_cn.php?_=${System.currentTimeMillis()}")
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                if (response!!.isSuccessful) {
                    val jsonObject = JsonParser().parse(response.body()!!.string()).asJsonObject
                    val jsonElement=jsonObject.get("count")
//                    this@MainActivity.runOnUiThread {
//                        textview!!.text=response.body()!!.string()
//                    }

                }
            }

        })
    }


}
