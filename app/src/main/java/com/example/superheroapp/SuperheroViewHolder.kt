package com.example.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)       // Añadimos el viewBinding para controlar cada item (superheroe)

    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name      // Asignamos el nombre correspondiente al textView de cada item
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)      // Con Picasso cargamos la imagen del superheroe en cada item
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }
    }
}