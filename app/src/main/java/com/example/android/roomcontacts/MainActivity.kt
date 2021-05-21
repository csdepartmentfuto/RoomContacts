package com.example.android.roomcontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var familyCategory: CardView
    private lateinit var friendsCategory: CardView
    private lateinit var schoolCategory: CardView
    private lateinit var workCategory: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        familyCategory = findViewById(R.id.family_category_container)
        friendsCategory = findViewById(R.id.friends_category_container)
        schoolCategory = findViewById(R.id.school_category_container)
        workCategory = findViewById(R.id.work_category_container)

        familyCategory.setOnClickListener {
            val intent = Intent(this, FamilyActivity::class.java)
            startActivity(intent)
        }

        friendsCategory.setOnClickListener {
            val intent = Intent(this, FriendsActivity::class.java)
            startActivity(intent)
        }

        schoolCategory.setOnClickListener {
            val intent = Intent(this, SchoolActivity::class.java)
            startActivity(intent)
        }

        workCategory.setOnClickListener {
            val intent = Intent(this, WorkActivity::class.java)
            startActivity(intent)
        }

    }
}