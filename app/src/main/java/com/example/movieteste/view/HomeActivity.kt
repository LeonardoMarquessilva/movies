package com.example.movieteste.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieteste.R
import com.example.movieteste.adapters.MovieAdapter
import com.example.movieteste.model.Movie
import com.example.movieteste.model.MovieResponse
import com.example.movieteste.service.MoviePopularApiInterface
import com.example.movieteste.service.MovieApiService
import com.example.movieteste.service.MovieTopreatedApiInterface
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_popular_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_popular_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_popular_list.adapter = MovieAdapter(movies)
        }

        rv_top_reated_list.layoutManager = LinearLayoutManager(this)
        rv_top_reated_list.setHasFixedSize(true)
        getMovieTopData { movies : List<Movie> ->
            rv_top_reated_list.adapter = MovieAdapter(movies)
        }

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MoviePopularApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }

    private fun getMovieTopData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieTopreatedApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
/* // Development
    fun startDetailActivity() {
        textView.setOnClickListener {
            val description: String = txt_descripition.text.toString()
            val intent =Intent (this,DetailActivity::class.java)
            intent.putExtra("value", description)
            startActivity(intent)

        }

    }
*/
}
