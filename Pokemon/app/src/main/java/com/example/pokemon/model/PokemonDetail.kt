package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

class PokemonDetail {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("sprites")
    var imagen: String? = null

    @SerializedName("height")
    var height: String? = null

    @SerializedName("weight")
    var weight: String? = null
}