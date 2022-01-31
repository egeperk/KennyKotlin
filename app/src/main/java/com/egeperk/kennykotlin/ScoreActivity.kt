package com.egeperk.kennykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    lateinit var textView3: TextView
    lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        textView3 = findViewById(R.id.textView3)
        var number = intent.getIntExtra("score",0)
        textView3.text = "Your Score: $number"

    }

    fun restartGame (view : View) {

        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }

}