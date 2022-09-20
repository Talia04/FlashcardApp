package com.tanya.flashcardapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashcardOption1 = findViewById<TextView>(R.id.option1)
        val flashcardOption2 = findViewById<TextView>(R.id.option2)
        val flashcardOption3 = findViewById<TextView>(R.id.option3)
        val answerVisibleToggle = findViewById<ImageView>(R.id.answers_visible_toggle)

        //Log.i("Tanya", "Answer revealed")

        flashcardOption1.setOnClickListener{

            flashcardOption1.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()

        }
        flashcardOption2.setOnClickListener{

            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
            flashcardOption2.setBackgroundColor(Color.GREEN)
        }
        flashcardOption3.setOnClickListener{

            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
            flashcardOption3.setBackgroundColor(Color.RED)
        }
        answerVisibleToggle.setOnClickListener{
            answerVisibleToggle.setImageResource(R.drawable.hide_answers)
            flashcardOption1.visibility = View.VISIBLE
            flashcardOption2.visibility = View.VISIBLE
            flashcardOption3.visibility = View.VISIBLE
        }
        }
    }
