package com.example.booksapp.model

import com.example.booksapp.model.Author

data class Book(
    val authors: List<Author>,
    val description: String,
    val id: String,
    val language: String,
    val title: String
    )
