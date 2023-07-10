package com.example.moviesdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper
import com.google.android.material.animation.AnimationUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val imagelist = arrayListOf(
        R.drawable.d932c0d40307ccee10bb9d050c183c42,
        R.drawable.ai,
        R.drawable.cake,
        R.drawable.birthday_icon,
        R.drawable.kid_120700,
        R.drawable.meme,
    )

    val api = "https://poetrydb.org/author,title/Shakespeare;Sonnet"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val retrofit = Retrofit.Builder()
         //   .baseUrl(api)
           // .addConverterFactory(GsonConverterFactory.create())
           // .build()
        val viewflipper = findViewById<ViewFlipper>(R.id.viewflipper)
        val inanimation = android.view.animation.AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outanimation = android.view.animation.AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        viewflipper.inAnimation = inanimation
        viewflipper.outAnimation = outanimation
        viewflipper.flipInterval = 3700
        for(image in imagelist) {
            val imageview = ImageView(this)
            imageview.setImageResource(image)
            imageview.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT,
            )
            imageview.scaleType = ImageView.ScaleType.CENTER_CROP
            viewflipper.addView(imageview)
        }
    }
}