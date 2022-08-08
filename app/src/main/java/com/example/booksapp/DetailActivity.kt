package com.example.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.adapter.AuthorAdapter
import com.example.booksapp.databinding.ActivityDetailBinding
import com.example.booksapp.model.BooksResponse
import com.example.booksapp.retrofit.ApiInterface
import com.example.booksapp.retrofit.ApiUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

open class DetailActivity : AppCompatActivity() {

//    private lateinit var description: TextView
//    private lateinit var id: TextView
//    private lateinit var language: TextView
//    private lateinit var title: TextView
    private lateinit var binding: ActivityDetailBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var authorAdapter: AuthorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiInterface = ApiUtility.getApi()
        var result = MutableLiveData<BooksResponse>()
        val idExtra = intent.getStringExtra("id")
        authorAdapter = AuthorAdapter(this)
        binding.authorId.adapter = authorAdapter
        binding.authorId.layoutManager= LinearLayoutManager(this)

        lifecycleScope.launch(Dispatchers.IO) {

            try {
                var response = apiInterface.getSingleBook(idExtra!!.toInt())
                if(response.isSuccessful){
                    result.postValue(response.body())
                    Log.d("mytag",response.isSuccessful.toString())
                }
            } catch(e: Exception){
                Log.d("exception", e.message.toString ())
            }
        }
        result.observe(this@DetailActivity) { data ->
            authorAdapter.setData1(data.books[0].authors)
            binding.descriptionTV.text = Html.fromHtml(data.books[0].description)
            binding.titleTV.text = data.books[0].title
            binding.languageTV.text = data.books[0].language
            Log.d("detailtag",data.toString())
        }
      }
}