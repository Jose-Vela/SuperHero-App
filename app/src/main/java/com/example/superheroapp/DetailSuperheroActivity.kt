package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroapp.databinding.ActivityDetailSuperheroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperheroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_detail_superhero)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch { // Lanza una corrutina. Dispatchers.IO indica que lo lance en un hilo secundario
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if (superheroDetail.body() != null){
                runOnUiThread { createUI(superheroDetail.body()!!) }
            }

        }
    }

    private fun createUI(superhero: SuperHeroDetailResponse) {
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}