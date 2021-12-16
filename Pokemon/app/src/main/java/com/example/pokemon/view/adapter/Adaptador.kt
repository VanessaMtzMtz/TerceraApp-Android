package com.example.pokemon.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemon.databinding.ListElementBinding
import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.Pokmon

class Adaptador(context: Context, pokemons: List<Pokemon>, onItemListener: OnItemListener): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    private val pokemons = pokemons
    private val mOnItemListener = onItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = ListElementBinding.inflate(layoutInflater)

        return ViewHolder(binding, mOnItemListener)
    }

    override fun onBindViewHolder(holder: Adaptador.ViewHolder, position: Int) {
        holder.bindData(pokemons[position])
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    interface OnItemListener{
        fun onItemClick(pokemon: Pokmon)
    }

    class ViewHolder(binding: ListElementBinding, onItemListener: OnItemListener): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private val tvTitle = binding.tvTitle
        private val onItemListener = onItemListener
        private lateinit var pokemon: Pokmon

        init{
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemListener.onItemClick(pokemon)
        }

        fun bindData(item: Pokemon){
            tvTitle.text = item.name
            //pokemon = item
        }

    }

}


