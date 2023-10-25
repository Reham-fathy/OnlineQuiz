package com.example.onlinequiz.models

data class QuestionStats(
    val categories: Categories,
    val overall: Overall
)
data class Overall(
    val total_num_of_pending_questions: Int,
    val total_num_of_questions: Int,
    val total_num_of_rejected_questions: Int,
    val total_num_of_verified_questions: Int
)

data class Categories(
    val total_num_of_pending_questions: Int,
    val total_num_of_questions: Int,
    val total_num_of_rejected_questions: Int,
    val total_num_of_verified_questions: Int
)