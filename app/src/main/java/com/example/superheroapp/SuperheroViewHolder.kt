package com.example.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)       // Añadimos el viewBinding para controlar cada item (superheroe)

    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.tvSuperheroName.text = superheroItemResponse.name      // Asignamos el nombre correspondiente al textView de cada item
    }
}