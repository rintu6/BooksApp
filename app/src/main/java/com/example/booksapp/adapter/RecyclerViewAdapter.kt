package com.example.booksapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.DetailActivity
import com.example.booksapp.databinding.CardviewLayoutBinding
import com.example.booksapp.model.BooksResponse

class RecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var bookList = BooksResponse()

    fun setData(bookList:BooksResponse){
        this.bookList = bookList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.binding.title.text = bookList.books[position].title
//        holder.binding.author.text = bookList.books[position].authors[0].first_name +" " + bookList.books[position].authors[0].last_name

        holder.binding.cardView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("id", bookList.books[position].id.toString())
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return bookList.books.size
    }

    class ViewHolder(val binding: CardviewLayoutBinding): RecyclerView.ViewHolder(binding.root)  {

    }
}