package com.example.pokemon.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApi {
    //https://pokeapi.co/api/v2/pokemon?limit=151

    @GET
    fun getPokemons(
        @Url url: String?
    ):Call<List<Pokmon>>

    @GET("api/v2/pokemon/")
    fun getPokemonDetail(
        @Query("id") id:String?
    ):Call<PokemonDetail>
}