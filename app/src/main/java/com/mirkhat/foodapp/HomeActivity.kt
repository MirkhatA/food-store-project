package com.mirkhat.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth= FirebaseAuth.getInstance()
        var currentUser=auth.currentUser

        val logout = findViewById<Button>(R.id.logoutBtn)

        if(currentUser==null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        logout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}