package com.mohitsharda.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mohitsharda.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity() {
    private var mCurrentPosition = 1
    private var mQuestionList: List<Questions>? = null
    private var mSelectedOptionPosition = 0
    private var mCorrectAnswers = 0
    private var mUserName: String? = null
    private lateinit var binding: ActivityQuizQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionView()
        if(mCurrentPosition == mQuestionList!!.size){
            binding.btnSubmit.text = "FINISH"
        }else{
            binding.btnSubmit.text = "SUBMIT"
        }
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "${mCurrentPosition}/${binding.progressBar.max}"

        binding.tvQuestion.text = question.question
        binding.ivImage.setImageResource(question.img)
        binding.tvOption1.text = question.optionOne
        binding.tvOption2.text = question.optionTwo
        binding.tvOption3.text = question.optionThree
        binding.tvOption4.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = listOf<TextView>(
            binding.tvOption1,
            binding.tvOption2,
            binding.tvOption3,
            binding.tvOption4
        )

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this@QuizQuestionActivity, R.drawable.default_option_border)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this@QuizQuestionActivity, R.drawable.selected_option_border)
    }

    fun onOptionSelect(view: View) {
        when (view.id) {
            R.id.tv_option1 -> selectedOptionView(binding.tvOption1, 1)
            R.id.tv_option2 -> selectedOptionView(binding.tvOption2, 2)
            R.id.tv_option3 -> selectedOptionView(binding.tvOption3, 3)
            R.id.tv_option4 -> selectedOptionView(binding.tvOption4, 4)
        }
    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> binding.tvOption1.background = ContextCompat.getDrawable(this, drawableView)
            2 -> binding.tvOption2.background = ContextCompat.getDrawable(this, drawableView)
            3 -> binding.tvOption3.background = ContextCompat.getDrawable(this, drawableView)
            4 -> binding.tvOption4.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
    fun onSubmit(view: View){
        if(mSelectedOptionPosition == 0){
            mCurrentPosition++
            if(mCurrentPosition <= mQuestionList!!.size){
                setQuestion()
            }
            else{
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.USER_NAME, mUserName)
                intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                startActivity(intent)
                finish()
            }
        }else{
            val question = mQuestionList?.get(mCurrentPosition - 1)
            if(question!!.correctAnswer != mSelectedOptionPosition){
                answerView(mSelectedOptionPosition,R.drawable.wrong_option_border)
            }else{
                mCorrectAnswers++
            }
            answerView(question!!.correctAnswer,R.drawable.correct_option_border)

            if(mCurrentPosition == mQuestionList!!.size){
                binding.btnSubmit.text = "FINISH"
            }else{
                binding.btnSubmit.text = "GO TO NEXT QUESTION"
            }
            mSelectedOptionPosition = 0
        }
    }
}