package com.example.booksapp.model

import com.example.booksapp.model.Book

data class BooksResponse
    (
    val books : List<Book>
    ){
        constructor(): this(//default value
            emptyList()
        )
    }
