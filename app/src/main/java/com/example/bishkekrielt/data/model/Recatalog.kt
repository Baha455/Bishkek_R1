package com.example.bishkekrielt.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recatalog (
    @SerializedName("image") val image : String,
    @SerializedName("title") val title : String,
    @SerializedName("location") val location : String,
    @SerializedName("price") val price : String,
    @SerializedName("area") val area : String,
    @SerializedName("kitchen") val kitchen : String,
    @SerializedName("floor") val floor : String,
    @SerializedName("rooms") val rooms : Int)
    : Parcelable

