package com.example.onlinequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    private lateinit var splashImg: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashImg=findViewById(R.id.splash_imageView)
        animateZoomOut()
    }

    private fun animateZoomOut()
    {
        splashImg.animate().
        scaleX(0.4f)
            .scaleY(0.4f)
            .setDuration(1000)
            .withEndAction {
                animateZoomIn()
            }.start()
    }


    private fun animateZoomIn()
    {
        splashImg.animate().
        scaleX(2.0f)
            .scaleY(2.0f)
            .setDuration(2000)
            .withEndAction {
                startNewActivity()
            }.start()
    }
    private fun startNewActivity()
    {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}
