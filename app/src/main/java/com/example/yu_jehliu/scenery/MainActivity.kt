package com.example.yu_jehliu.scenery

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.scheduleAtFixedRate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        val imageRot = findViewById<ImageButton>(R.id.scene)
        val timer = fixedRateTimer(name = "ImageSlides", daemon = true, initialDelay = 2000, period = 2000){

            this@MainActivity.runOnUiThread(Runnable{
                when(count){
                    0 -> imageRot.setImageResource(R.drawable.grandcanyon)
                    1 -> imageRot.setImageResource(R.drawable.taroko)
                    2 -> imageRot.setImageResource(R.drawable.yellowstone)
                    3 -> {imageRot.setImageResource(R.drawable.yosemite)
                        count = -1}
                }
            })
            
            count += 1
            Log.d("TimerCount","count: $count")
        }
//        val timer = Timer("schedule", true)
//        timer.scheduleAtFixedRate(delay = 0, period = 2){
//            when(count){
//                1 -> scene.setImageResource(R.drawable.taroko)
//                2 -> scene.setImageResource(R.drawable.yellowstone)
//                3 -> {scene.setImageResource(R.drawable.yosemite)
//                      count = -1}
//            }
//            count += 1
//        }

    }



    fun showPage(image: ImageButton){

    }
}
