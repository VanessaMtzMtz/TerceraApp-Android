package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

class Pokmon {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("results")
    var results: Results? = null

}

class Results{
    @SerializedName ("name")
    var name: String? = null
}