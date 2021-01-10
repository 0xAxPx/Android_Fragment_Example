package com.peshale.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id: Long) {
        val view = findViewById<View>(R.id.fragment_container)
        if (view != null) {
            val detailsFragment = WorkoutDetailFragment()
            val transaction = supportFragmentManager.beginTransaction()
            detailsFragment.workoutId = id
            transaction.replace(R.id.fragment_container, detailsFragment)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id)
            startActivity(intent)
        }
    }
}