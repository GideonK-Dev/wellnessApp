package com.gideon.farasi_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        healthy recipies intent
//        finding the views from the layout using their ids

//        create a variable to store the buttons

        val recipe=findViewById<Button>(R.id.recipies)

//        setOnClickListener
        recipe.setOnClickListener {
//            write your intents
            val recipeIntent= Intent(applicationContext, HealthyRecipies::class.java)
            startActivity(recipeIntent)
        }

//        nutrition intent
        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {

            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)
        }

//        meditation intent
        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {

            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
        }

//        Progress intent
        val progress=findViewById<Button>(R.id.progress)

        progress.setOnClickListener {

            val progressIntent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(progressIntent)
        }

//        motivation intent
        val motivation=findViewById<Button>(R.id.motivation)

        motivation.setOnClickListener {

            val motivationIntent= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(motivationIntent)
        }

//        exercise intent
        val exercise=findViewById<Button>(R.id.exercise)

        exercise.setOnClickListener {

            val exerciseIntent= Intent(applicationContext, StartExercise::class.java)
            startActivity(exerciseIntent)
        }


//        goals exercise
        val goals=findViewById<Button>(R.id.goals)

        goals.setOnClickListener {

            val goalsIntent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(goalsIntent)
        }



    }
}