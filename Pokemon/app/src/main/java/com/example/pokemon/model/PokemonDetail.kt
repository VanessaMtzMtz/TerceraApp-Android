package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

class PokemonDetail {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("species")
    var species: Species? = null

    @SerializedName("sprites")
    var sprites: Sprites? = null

    @SerializedName("height")
    var height: String? = null

    @SerializedName("weight")
    var weight: String? = null
}

class Species{
    @SerializedName("name")
    var name: String? = null
}
class Sprites{
    @SerializedName("other")
    var other: Other? = null

}

class Other{
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork? = null
}

class OfficialArtwork{
    @SerializedName("front_default")
    var frontDefault: String? = null
}