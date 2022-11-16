package com.example.proj4

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var totalTime: Int = 0

    lateinit var playBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playBtn = findViewById(R.id.playBtn)
        playBtn.setOnClickListener {
            playBtnClick(it)
        }

        mp = MediaPlayer.create(this, R.raw.music)
        mp.isLooping = true
        mp.setVolume(0.5f, 0.5f)
        totalTime = mp.duration
    }


    fun playBtnClick(v: View) {

        if (mp.isPlaying) {
            // Stop
            mp.pause()
            playBtn.setBackgroundResource(R.drawable.play)


        } else {
            // Start
            mp.start()
            playBtn.setBackgroundResource(R.drawable.stop)
        }
    }
}