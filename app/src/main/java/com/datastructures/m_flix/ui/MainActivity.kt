package com.datastructures.m_flix.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.datastructures.m_flix.R
import com.datastructures.m_flix.pojo.MoviesContainer
import com.datastructures.m_flix.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
            movieViewModel.getPopularMovies()

        movieViewModel.popularMoviesMLD.observe(this){
            Log.d("meow" , movieViewModel.popularMoviesMLD.value.toString())
        }
    }
}