package com.example.retrofit_ii_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private var responseList : List<ResponseDTO> = listOf<ResponseDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPost.setOnClickListener{
            callApi()
        }

    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object :retrofit2.Callback<List<ResponseDTO>>{
                override fun onResponse(
                    call: Call<List<ResponseDTO>>,
                    response: Response<List<ResponseDTO>>
                ) {
                    responseList = response.body()!!
                    setRecyclerAdapter()
                }

                override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {
                }

            })
            }

    private fun setRecyclerAdapter() {
        val postAdapter = PostAdapter(responseList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager= linearLayoutManager
    }
}
