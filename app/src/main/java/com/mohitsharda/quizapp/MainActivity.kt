package com.mohitsharda.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mohitsharda.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun startTheQuiz(view: View) {

        if (binding.etName.text.toString().isEmpty()) {
            binding.etName.error = "Please enter your name"
        } else {
            val intent = Intent(this, QuizQuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME,binding.etName.text.toString())
            startActivity(intent)
            finish()
        }
    }

}