package com.hofc.hofc.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by maladota on 01/09/2017.
 */
@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if(show) View.VISIBLE else View.GONE
}

@BindingAdapter("bindImage")
fun imageLoader(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}
class BindingAdapter