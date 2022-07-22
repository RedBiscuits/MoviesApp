package com.datastructures.m_flix.pojo

data class MoviesContainer(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)