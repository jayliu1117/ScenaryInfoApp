package com.example.yu_jehliu.scenery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.scheduleAtFixedRate
import android.webkit.WebViewClient



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        val imageRot = findViewById<ImageButton>(R.id.scene)
        val timer = fixedRateTimer(name = "ImageSlides", daemon = true, initialDelay = 2000, period = 2000){

            count += 1
            // Using the UIthread to change the imageButton
            this@MainActivity.runOnUiThread(Runnable{
                when(count){
                    0 -> imageRot.setImageResource(R.drawable.grandcanyon)
                    1 -> imageRot.setImageResource(R.drawable.taroko)
                    2 -> imageRot.setImageResource(R.drawable.yellowstone)
                    3 -> { imageRot.setImageResource(R.drawable.yosemite)
                        count = -1}
                }
            })
            imageRot.id = count
        }
    }



    fun showPage(image: View){
        val id = image.id
        val myWeb = findViewById<WebView>(R.id.sceneInfo)

        myWeb.webViewClient = WebViewClient()
        myWeb.visibility = View.VISIBLE

        when(id){
            0 -> myWeb.loadUrl("https://en.wikipedia.org/wiki/Grand_Canyon")
            1 -> myWeb.loadUrl("https://en.wikipedia.org/wiki/taroko")
            2 -> myWeb.loadUrl("https://en.wikipedia.org/wiki/Yellowstone_National_Park")
            3 -> myWeb.loadUrl("https://en.wikipedia.org/wiki/yosemite")
        }

    }
}
