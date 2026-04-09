package com.gideon.farasi_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

//    declares a variable to store our interstitial ad
    private var mInterstitialAd: InterstitialAd?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        implementation of the banner add
        MobileAds.initialize(this)
//        Starts the Google AdMob SDK
//        Prepares your app to load adds
//        Must be called before showing ads

        val adView=findViewById<AdView>(R.id.adView)
//        Get the Adview from the layout
//        Connects your Kotlin code to the ad view in xml
//        R.id.adView-the banner ad you placed in your layout

        val adRequest= AdRequest.Builder().build()
        adView.loadAd(adRequest)
//        Load the Ad
//        Send the Request to "admob"
//        AdMob returns an ad
//        The ad is displayed in your app


//        call the function to load the ad
        loadInterstitialAd()



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
            showInterstitialAd()
        }

//        nutrition intent
        val nutrition=findViewById<Button>(R.id.nutrition)

        nutrition.setOnClickListener {

            val nutritionIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(nutritionIntent)
            showInterstitialAd()
        }

//        meditation intent
        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {

            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
            showInterstitialAd()
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

//    a function to load our ad from the server
fun loadInterstitialAd() {
    val adRequest = AdRequest.Builder().build()

    InterstitialAd.load(
        this,
        "ca-app-pub-3940256099942544/1033173712", // Test ID
        adRequest,
        object : InterstitialAdLoadCallback() {

            override fun onAdLoaded(ad: InterstitialAd) {
                mInterstitialAd = ad
            }

            override fun onAdFailedToLoad(error: LoadAdError) {
                mInterstitialAd = null
            }
        }
    )
}
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }


}