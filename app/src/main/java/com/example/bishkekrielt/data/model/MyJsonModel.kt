package com.example.bishkekrielt.data.model

import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName


data class Data (
    val catalog: List<Recatalog> )

@VersionedParcelize
data class Recatalog (
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: String,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: String,
    @SerializedName("iteminfo") val iteminfo: List<ItemInfo>)

data class ItemInfo(
    @SerializedName("fullInfo") val fullInfo: String,
)



