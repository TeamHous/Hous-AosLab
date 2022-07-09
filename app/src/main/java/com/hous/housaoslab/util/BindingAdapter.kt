package com.hous.housaoslab.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isSelected")
fun ImageView.setSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}

@BindingAdapter("app:imageRes")
fun ImageView.setDrawable(@DrawableRes drawableRes: Int) {
    this.setImageResource(drawableRes)
}
