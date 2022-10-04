package com.tanya.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class AddQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)



        val cancel_btn  = findViewById<ImageView>(R.id.cancel_btn)
        val save_btn = findViewById<ImageView>(R.id.save_btn)
        val question_text = findViewById<EditText>(R.id.add_question_input_text)
        val answer_text = findViewById<EditText>(R.id.add_answer_input_text)

        cancel_btn.setOnClickListener{
            finish()

        }


        save_btn.setOnClickListener {
            val data = Intent()
            data.putExtra("QUESTION", question_text.text.toString())
            data.putExtra("ANSWER", answer_text.text.toString())
            setResult(RESULT_OK, data)
            finish()
        }


    }
}