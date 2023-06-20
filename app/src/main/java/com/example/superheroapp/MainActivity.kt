package com.example.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import com.example.superheroapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperheroAdapter

    private lateinit var toast: Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("josé", "Presionado :$query")
                searchByName(query.orEmpty())   // Si query es null, devolverá un texto vacio que se enviará a searchByName()
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        binding.ivEmptyResults.isVisible = true

        adapter = SuperheroAdapter { superheroId -> navigateToDetail(superheroId) }
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch { // Lanza una corrutina. Dispatchers.IO indica que lo lance en un hilo secundario
            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful) {
                val response: SuperHeroDataResponse = myResponse.body()!!
                if (response.response != "error") {
                    runOnUiThread { showResults(response.superheroes, false) }     // Correr en el 'hilo principal' lo que esté entre las llaves. Solo el 'hilo principal' puede crear vistas
                } else {
                    runOnUiThread { showResults(emptyList(), true) }
                }
            } else {
                runOnUiThread { showResults(emptyList(), true) }
            }
        }
    }

    private fun showResults(result: List<SuperheroItemResponse>, emptyResults: Boolean ) {
        var textToast = "Sin Resultados"
        adapter.updateList(result)
        binding.progressBar.isVisible = false
        binding.ivEmptyResults.isVisible = emptyResults
        if (!emptyResults) textToast = "Mostrando Resultados"
        toast = Toast.makeText(this, textToast, Toast.LENGTH_LONG)
        toast.show()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}