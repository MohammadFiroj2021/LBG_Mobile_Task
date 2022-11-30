package com.app.gitHubUserList.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.app.gitHubUserList.R

@BindingAdapter("imageFromUrl")
fun AppCompatImageView.bindImageFromUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        load(url)
    }
}

