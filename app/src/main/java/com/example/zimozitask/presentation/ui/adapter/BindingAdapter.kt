package com.example.zimozitask.presentation.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.zimozitask.data.model.Data

@BindingAdapter("img")
fun bindImg(imageView: ImageView, data: Data?) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.imgURL)
            .into(imageView)
    }
}