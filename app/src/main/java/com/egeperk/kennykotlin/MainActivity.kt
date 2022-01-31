package com.egeperk.kennykotlin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.net.FileNameMap
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var handler : Handler
    lateinit var runnable : Runnable
    lateinit var button : Button
    lateinit var button2 : Button
    var number: Int = 0
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView5: ImageView
    lateinit var imageView6: ImageView
    lateinit var imageView7: ImageView
    lateinit var imageView8: ImageView
    lateinit var imageView9: ImageView
    lateinit var imageView10: ImageView
    lateinit var imageView11: ImageView
    lateinit var imageView12: ImageView
    lateinit var imageArray : ArrayList<ImageView>

    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        imageView7 = findViewById(R.id.imageView7)
        imageView8 = findViewById(R.id.imageView8)
        imageView9 = findViewById(R.id.imageView9)
        imageView10 = findViewById(R.id.imageView10)
        imageView11 = findViewById(R.id.imageView11)
        imageView12 = findViewById(R.id.imageView12)

      imageArray = arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12)

        countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                textView.text = "Time left: ${millisUntilFinished / 1000}"

            }

            override fun onFinish() {
                textView.text = "Time is over!"
                handler.removeCallbacks(runnable)
                for (imageView in imageArray) {
                    imageView.visibility = View.INVISIBLE


                    intent = Intent(applicationContext, ScoreActivity::class.java)
                    intent.putExtra("score", number)
                    startActivity(intent)


                }
            }

        }

        number = 0
        for (imageView in imageArray) {
            imageView.isClickable = false
        }
        hideImages()

    }
    fun add(view: View) {
        number++
        textView2.text = "Score: $number"
    }


    fun start(view : View) {

        for (imageView in imageArray) {
            imageView.isClickable = true

            countDownTimer.start()

            button.isEnabled = false

        }
    }

    fun restart(view : View) {

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Restart Game")
        alert.setMessage("Are you sure?")
        alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
        recreate()
        countDownTimer.cancel()})
        alert.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> onResume()  })
        alert.show()


    }



    fun hideImages() {
        handler = Handler()
        runnable = object : Runnable {
            override fun run() {
                for (imageView in imageArray) {
                    imageView.visibility = View.INVISIBLE
                }

                val random = Random()
                val i = random.nextInt(12)
                imageArray[i].isVisible = true
                handler.postDelayed(runnable, 500)

            }

        }

        handler.post(runnable)
    }

}