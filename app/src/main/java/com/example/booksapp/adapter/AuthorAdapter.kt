package com.example.booksapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.AuthorActivity
import com.example.booksapp.databinding.AuthorviewLayoutBinding
import com.example.booksapp.model.Author

class AuthorAdapter(val context : Context) : RecyclerView.Adapter<AuthorAdapter.ViewHolder>() {

    var authorList = emptyList<Author>()

    fun setData1(authorList: List<Author>){
        this.authorList = authorList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AuthorviewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.dob.text = authorList[position].dob
        holder.binding.dod.text = authorList[position].dod
        holder.binding.firstName.text = authorList[position].first_name
        holder.binding.id.text = authorList[position].id
        holder.binding.lastName.text = authorList[position].last_name

        holder.binding.authorcard.setOnClickListener {
            val intent = Intent(it.context, AuthorActivity::class.java)
            intent.putExtra("dob", authorList[position].dob.toString())
            intent.putExtra("dod", authorList[position].dod.toString())
            intent.putExtra("firstname",authorList[position].first_name.toString())
            intent.putExtra("id",authorList[position].id)
            intent.putExtra("lastname",authorList[position].last_name.toString())
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return authorList.size
    }

    class ViewHolder(val binding: AuthorviewLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}