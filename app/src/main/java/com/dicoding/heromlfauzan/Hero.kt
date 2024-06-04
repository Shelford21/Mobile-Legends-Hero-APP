package com.dicoding.heromlfauzan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int,
    val alias: String,
    val gender: String,
    val species: String,
    val damagetype:String
) : Parcelable