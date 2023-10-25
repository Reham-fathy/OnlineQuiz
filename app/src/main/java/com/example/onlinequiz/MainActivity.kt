package com.example.onlinequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onlinequiz.databinding.ActivityMainBinding
import com.example.onlinequiz.utils.QuizClass

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val quizClass=QuizClass(this)
    quizClass.getQuizList(5,null,null,null,binding?.questionList!!,binding?.questionSize!!)

    }
}