package com.tanya.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)

        findViewById<TextView>(R.id.flashcard_question).setOnClickListener{

            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE
            Toast.makeText(this, "Answer revealed", Toast.LENGTH_SHORT).show()

            Log.i("Tanya", "Answer revealed")

            findViewById<TextView>(R.id.flashcard_answer).setOnClickListener{

                flashcardQuestion.visibility = View.VISIBLE
                flashcardAnswer.visibility = View.INVISIBLE
            }
        }
    }
}