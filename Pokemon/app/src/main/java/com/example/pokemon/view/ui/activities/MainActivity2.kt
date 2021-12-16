package com.example.pokemon.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pokemon.databinding.ActivityMain2Binding
import com.example.pokemon.model.PokeApi
import com.example.pokemon.model.PokemonDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    private val BASE_URL = "https://pokeapi.co/"
    private val LOGTAG = "LOGS"

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val id = bundle?.getString("id","0")

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)

        val call: Call<PokemonDetail> = pokeApi.getPokemonDetail(id)

        call.enqueue(object: Callback<PokemonDetail>{
            override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                Log.d(LOGTAG, "${response.body()?.sprites?.other?.officialArtwork?.frontDefault}")
                with(binding){
                    pbConexion.visibility = View.INVISIBLE
                    tvNombre.text = response.body()?.species?.name
                    Glide.with(this@MainActivity2).load(response.body()?.sprites?.other?.officialArtwork?.frontDefault)
                        .into(binding.ivPokemon)
                    tvAltura.text = response.body()?.height
                    tvPeso.text = response.body()?.weight
                }
            }

            override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                with(binding){
                    pbConexion.visibility = View.INVISIBLE
                    Toast.makeText(this@MainActivity2, "Error en la conexión", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun clickButtonRegresar(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}