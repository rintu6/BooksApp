package com.example.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.booksapp.databinding.ActivityAuthorBinding
import com.example.booksapp.databinding.ActivityDetailBinding

class AuthorActivity : DetailActivity() {

//    private lateinit var dob: TextView
//    private lateinit var dod: TextView
//    private lateinit var first_name: TextView
//    private lateinit var id: TextView
//    private lateinit var last_name: TextView
    private lateinit var binding: ActivityAuthorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dobExtra = intent.getStringExtra("dob")
        val dodExtra = intent.getStringExtra("dod")
        val firstNameExtra = intent.getStringExtra("firstname")
        val idExtra = intent.getStringExtra("id")
        val lastNameExtra = intent.getStringExtra("lastname")

        binding.dob.text = dobExtra.toString()
        binding.dod.text = dodExtra.toString()
        binding.firstName.text = firstNameExtra.toString()
        binding.id.text = idExtra.toString()
        binding.lastName.text =lastNameExtra.toString()


    }
}