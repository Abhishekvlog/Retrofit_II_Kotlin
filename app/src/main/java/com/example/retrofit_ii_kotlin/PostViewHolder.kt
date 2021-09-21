package com.example.retrofit_ii_kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

    fun setData(responseDTO: ResponseDTO){
        view.tvName.text = responseDTO.name
        view.tvBody.text = responseDTO.body
        view.tvEmail.text = responseDTO.email
    }
}