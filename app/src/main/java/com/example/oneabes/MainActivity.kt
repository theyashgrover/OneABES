package com.example.oneabes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        mAuth = FirebaseAuth.getInstance()
        val user: FirebaseUser? = mAuth!!.getCurrentUser()
        if (user == null) {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        val firstFragment=EventsFragment()
        val secondFragment=AttendanceFragment()
        val thirdFragment=ProfileFragment()

        setCurrentFragment(secondFragment)
        val bottom_navigation = findViewById<NavigationBarView>(R.id.bottom_navigation)
        bottom_navigation.setBackgroundColor(resources.getColor(R.color.bottom_menu))
        bottom_navigation.selectedItemId = R.id.nav_attendance

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_events->setCurrentFragment(firstFragment)
                R.id.nav_attendance->setCurrentFragment(secondFragment)
                R.id.nav_profile->setCurrentFragment(thirdFragment)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}