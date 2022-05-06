package com.example.oneabes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user: FirebaseUser? = mAuth!!.getCurrentUser()
        if (user == null) {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }else{
            val tv = findViewById<TextView>(R.id.uid)
            tv.text = mAuth!!.currentUser!!.email
        }

        val logout = findViewById(R.id.logout) as Button
        logout.setOnClickListener(View.OnClickListener { view: View? ->
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        })
    }
}


