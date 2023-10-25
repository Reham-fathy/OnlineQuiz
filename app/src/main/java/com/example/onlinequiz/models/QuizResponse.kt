package com.example.onlinequiz.models

data class QuizResponse(
    val response_code: Int,
    val results: List<QuizQuestion>
)
data class QuizQuestion(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String
)