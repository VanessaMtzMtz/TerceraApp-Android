package com.example.pokemon.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.model.PokeApi
import com.example.pokemon.model.Pokmon
import com.example.pokemon.view.adapter.Adaptador
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), Adaptador.OnItemListener {
    private val BASE_URL = "https://pokeapi.co/"
    private val LOGTAG = "LOGS"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi = retrofit.create(PokeApi::class.java)
        val call: Call<Pokmon> = pokeApi.getPokemons("api/v2/pokemon?limit=151")

        call.enqueue(object: Callback<Pokmon>{
            override fun onResponse(call: Call<Pokmon>, response: Response<Pokmon>) {
                Log.d(LOGTAG, "Respuesta del servidor: ${response.toString()}")

                for(pokeTmp in response.body()!!.results!!){
                    Log.d(LOGTAG,"Nombre: ${pokeTmp.name}")
                }
                val adaptador = Adaptador(this@MainActivity, response.body()!!.results!!,this@MainActivity)

               with(binding){
                   rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                   rvMenu.adapter = adaptador
                }

            }

            override fun onFailure(call: Call<Pokmon>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error en la conexión",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onItemClick(pokemon: Pokmon) {
        val parametros = Bundle()
        parametros.putString("id", pokemon.id)
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtras(parametros)
        startActivity(intent)
    }

}
