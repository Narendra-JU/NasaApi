package com.example.nasaapi

import RetrofitFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var titletext:TextView
    lateinit var photovalue:ImageView
    lateinit var desciptiontext:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titletext=findViewById(R.id.titlePOTD)
        desciptiontext=findViewById(R.id.textDesPOTD)
        photovalue=findViewById(R.id.imagePOTD)



        val retrofitService=RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response=retrofitService.getApodDataAsync()

            try {
                withContext(Dispatchers.Main){
                    titletext.setText(response.title)
                    Glide.with(this@MainActivity).
                    load(response.url).centerInside()
                        .into(photovalue)
                    desciptiontext.setText(response.explanation)

                }
            }catch (e:Throwable){
                Log.d("REQUEST","went wrong")
            }
        }
    }
}