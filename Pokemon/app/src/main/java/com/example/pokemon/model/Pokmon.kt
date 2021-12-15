package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

class Pokmon {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null
}