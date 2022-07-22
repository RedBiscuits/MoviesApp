package com.datastructures.m_flix.remote

import com.datastructures.m_flix.constants.Constants
import com.datastructures.m_flix.pojo.MovieDetails
import com.datastructures.m_flix.pojo.MoviesContainer
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String = Constants.API_KEY
                         , @Query("language") language: String = "en-US"
                         , @Query("page") page :String = "1" )
    : Response<MoviesContainer>

    @GET("search/movie")
    suspend fun getParticularMovie(@Query("api_key") apiKey : String = Constants.API_KEY
                           , @Query("language") language: String = "en-US"
                           , @Query("query") query: String
                           , @Query("page") page :String = "1")
    : Response<MoviesContainer>

    @GET("movie/{movie_id}")
    suspend fun getMovieById(@Path("movie_id") movie_id : String
                     , @Query("language") language: String = "en-US"
                     , @Query("api_key") apiKey : String = Constants.API_KEY)
    : Response<MovieDetails>





}