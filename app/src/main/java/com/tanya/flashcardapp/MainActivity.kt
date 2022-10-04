package com.tanya.flashcardapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
        val showAnswerToggle = findViewById<ImageView>(R.id.show_answer_toggle)
        val addQuestionButton = findViewById<ImageView>(R.id.add_question_button)
        val hideAnswerToggle = findViewById<ImageView>(R.id.hide_answer_toggle)

        flashcardOption1.setOnClickListener {

            flashcardOption1.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()

        }
        flashcardOption2.setOnClickListener {

            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show()
            flashcardOption2.setBackgroundColor(Color.GREEN)
        }
        flashcardOption3.setOnClickListener {

            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show()
            flashcardOption3.setBackgroundColor(Color.RED)
        }
        showAnswerToggle.setOnClickListener {
            //answerVisibleToggle.setImageResource(R.drawable.hide_answers)
           /* flashcardOption1.visibility = View.VISIBLE
            flashcardOption2.visibility = View.VISIBLE
            flashcardOption3.visibility = View.VISIBLE*/

            flashcardAnswer.visibility = View.VISIBLE
            showAnswerToggle.visibility = View.INVISIBLE
            hideAnswerToggle.visibility = View.VISIBLE
            Log.i("Shown", "Answer Shown")

        }
        hideAnswerToggle.setOnClickListener {

            flashcardAnswer.visibility = View.INVISIBLE
            showAnswerToggle.visibility = View.VISIBLE
            hideAnswerToggle.visibility = View.INVISIBLE
            Log.i("Hidden", "Answer Hidden")
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())

        { result ->

                val data: Intent? = result.data
                if (data != null) {
                    val questionText = data.getStringExtra("QUESTION")
                    val answerText = data.getStringExtra("ANSWER")

                    flashcardQuestion.text = questionText
                    flashcardAnswer.text = answerText

                    // Log the value of the strings for easier debugging
                    Log.i("MainActivity", "QUESTION: $questionText")
                    Log.i("MainActivity", "ANSWER: $answerText")
                } else {
                    Log.i("MainActivity", "Returned null data from AddCardActivity")

                }

            }
        val intent = Intent(this, AddQuestionActivity::class.java)
        addQuestionButton.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            showAnswerToggle.visibility = View.VISIBLE
            hideAnswerToggle.visibility = View.INVISIBLE

            resultLauncher.launch(intent)
            }

        }
    }

