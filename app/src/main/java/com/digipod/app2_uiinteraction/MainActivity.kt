package com.digipod.app2_uiinteraction

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //    define the view objects
    private lateinit var btnChangeIntro: Button
    private lateinit var textIntro: TextView
    private lateinit var cbChgBg: CheckBox
    private lateinit var container: ViewGroup
    private lateinit var sbChangeTextSize : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnChangeIntro = findViewById(R.id.btnChangeIntro)
        textIntro = findViewById(R.id.textIntro)
        cbChgBg = findViewById(R.id.cbChangeBackground)
        container = findViewById(R.id.container)
        sbChangeTextSize = findViewById(R.id.sbChangeTextSize)

        // changing the text of textview
        textIntro.text = "A very simple example of UI interaction"
        textIntro.setTextColor(Color.BLUE)
        cbChgBg.setTextColor(Color.BLUE)
        // change default background color of container
        container.setBackgroundColor(Color.WHITE)

        // event listener for button
        btnChangeIntro.setOnClickListener {
            textIntro.text = "You have clicked the button to change the text"
            textIntro.textSize = 20f
        }

        // checkbox event listener
        cbChgBg.setOnCheckedChangeListener{ cb, state->
            if (state) {
                container.setBackgroundColor(Color.DKGRAY)
                textIntro.setTextColor(Color.LTGRAY)
                cbChgBg.setTextColor(Color.LTGRAY)
            } else {
                container.setBackgroundColor(Color.WHITE)
                textIntro.setTextColor(Color.BLUE)
                cbChgBg.setTextColor(Color.BLUE)
            }
        }

        // seekbar event listener
        sbChangeTextSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textIntro.textSize = progress.toFloat()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    }
}