package com.mohitsharda.quizapp

object Constants {

    const val USER_NAME = "username"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    private const val str = "What country this flag belong to?"
    fun getQuestions(): List<Questions> {
        return listOf(
            Questions(
                1,
                str,
                R.drawable.ic_flag_of_argentina,
                "Argentina",
                "India",
                "Brazil",
                "Denmark",
                1
            ),
            Questions(
                2,
                str,
                R.drawable.ic_flag_of_australia,
                "Belgium",
                "Australia",
                "New Zealand",
                "China",
                2
            ),
            Questions(3, str, R.drawable.ic_flag_of_india, "Kuwait", "India", "Japan", "Fiji", 2),
            Questions(
                4,
                str,
                R.drawable.ic_flag_of_brazil,
                "Denmark",
                "Norway",
                "New Zealand",
                "Brazil",
                4
            ),
            Questions(
                5,
                str,
                R.drawable.ic_flag_of_germany,
                "Nepal",
                "Germany",
                "America",
                "Japan",
                2
            ),
            Questions(
                6,
                str,
                R.drawable.ic_flag_of_denmark,
                "South Korea",
                "Japan",
                "Denmark",
                "West Indies",
                3
            ),
            Questions(
                7,
                str,
                R.drawable.ic_flag_of_fiji,
                "Fiji",
                "Brazil",
                "Sri Lanka",
                "England",
                1
            ),
            Questions(
                8,
                str,
                R.drawable.ic_flag_of_kuwait,
                "UAE",
                "Saudi Arabia",
                "Jordan",
                "Kuwait",
                4
            ),
            Questions(
                9,
                str,
                R.drawable.ic_flag_of_belgium,
                "North Korea",
                "China",
                "Belgium",
                "Austria",
                3
            ),
            Questions(
                10,
                str,
                R.drawable.ic_flag_of_new_zealand,
                "Iraq",
                "New Zealand",
                "England",
                "Australia",
                2
            ),
        )
    }
}