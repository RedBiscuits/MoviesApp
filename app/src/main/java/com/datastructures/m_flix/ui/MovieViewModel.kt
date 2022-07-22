package com.datastructures.m_flix.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.datastructures.m_flix.pojo.MoviesContainer
import com.datastructures.m_flix.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel() {
    private val retrofitAPI = RetrofitInstance.api
    var popularMoviesMLD : MutableLiveData<MoviesContainer> = MutableLiveData()

    fun getPopularMovies(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                popularMoviesMLD.value = retrofitAPI.getPopularMovies().body()
            }
        }
    }
}