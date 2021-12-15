package com.example.pokemon.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.pokemon.R
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.model.PokeApi
import com.example.pokemon.model.Pokmon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://pokeapi.co/"
    private val LOGTAG = "LOGS"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)
        val call: Call<List<Pokmon>> = pokeApi.getPokemons("api/v2/pokemon")

        call.enqueue(object: Callback<List<Pokmon>>{
            override fun onResponse(call: Call<List<Pokmon>>, response: Response<List<Pokmon>>) {
                Log.d(LOGTAG, "Respuesta del servidor: ${response.toString()}")
                binding.pbConexion.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<List<Pokmon>>, t: Throwable) {
                Log.d(LOGTAG, "Error")
                Toast.makeText(this@MainActivity,"Error en la conexión",Toast.LENGTH_SHORT).show()
                binding.pbConexion.visibility = View.INVISIBLE
            }
        })
    }

}