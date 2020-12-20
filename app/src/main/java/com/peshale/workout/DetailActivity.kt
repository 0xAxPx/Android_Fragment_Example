package com.peshale.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as WorkoutDetailFragment
        val id = intent.extras?.get(EXTRA_WORKOUT_ID)
        frag.workoutId = id as Long
    }

    companion object {
        const val EXTRA_WORKOUT_ID = "id"
    }
}