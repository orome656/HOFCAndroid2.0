package com.hofc.hofc.adapters

import android.databinding.BindingAdapter
import android.view.View

/**
 * Created by maladota on 01/09/2017.
 */
@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if(show) View.VISIBLE else View.GONE
}
class BindingAdapter