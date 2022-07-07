package com.hous.housaoslab.ui.home.model

import androidx.annotation.DrawableRes

data class ComingUpData(
    @DrawableRes
    val shape: Int,
    @DrawableRes
    val image: Int,
    val day: String
)
