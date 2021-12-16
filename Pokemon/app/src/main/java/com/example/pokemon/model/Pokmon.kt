package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

class Pokmon {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("results")
    var results: List<Pokemon>? = null
}

class Pokemon{
    @SerializedName ("name")
    var name: String? = null
}