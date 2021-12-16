package com.example.pokemon.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApi {

    @GET
    fun getPokemons(
        @Url url: String?
    ):Call<Pokmon>

    @GET("api/v2/pokemon/{id}")
    fun getPokemonDetail(
        @Path("id") id:String?
    ):Call<PokemonDetail>
}