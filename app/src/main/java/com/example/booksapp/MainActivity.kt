package com.example.booksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.adapter.RecyclerViewAdapter
import com.example.booksapp.databinding.ActivityMainBinding
import com.example.booksapp.model.BooksResponse
import com.example.booksapp.retrofit.ApiInterface
import com.example.booksapp.retrofit.ApiUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    private lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAdapter = RecyclerViewAdapter(this)
        binding.recyclerView.adapter= recyclerViewAdapter
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        apiInterface = ApiUtility.getApi()
        var result = MutableLiveData<BooksResponse>()

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                var response = apiInterface.getAllBooks()
                if(response.isSuccessful){
                    result.postValue(response.body())
                }
            }
            catch(e: Exception){
                Log.d("exception", e.message.toString ())
            }
        }
        result.observe(this@MainActivity) {
            recyclerViewAdapter.setData(it)
        }
    }
}