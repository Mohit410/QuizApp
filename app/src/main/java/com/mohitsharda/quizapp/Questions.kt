package com.mohitsharda.quizapp

data class Questions(
    val id: Int,
    val question: String,
    val img: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
    )