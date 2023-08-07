package com.example.movieteste.service

import com.example.movieteste.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MoviePopularApiInterface {

    @GET("/3/movie/popular?api_key=ed14716f0a92f2daa0ea788dd2b7dd81")
    fun getMovieList(): Call<MovieResponse>


}

interface MovieTopreatedApiInterface {

    @GET("/3/movie/top_rated?api_key=ed14716f0a92f2daa0ea788dd2b7dd81")
    fun getMovieList(): Call<MovieResponse>

}