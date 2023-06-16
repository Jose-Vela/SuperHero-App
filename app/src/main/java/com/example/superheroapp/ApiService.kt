package com.example.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /* Cuando hacemos llamadas a una API, al BackEnd, a una BD, a internet o cálculos pesados; por lo regular NO lo hacemos en
     el 'hilo principal' (Main Thread), ya que esto podria alentar nuestra App. En Kotlin, para no trabajar en el 'hilo principal',
     podemos hacer uso de las Corrutinas (Coroutines), ya que estas nos permiten hacer llamadas ASINCRONAS, es decir,
     ejecutar intrucciones en otro 'hilo', sin interrumpir las del 'hilo principal' */

    // Indicamos que utilizaremos llamadas de tipo GET
    @GET("api/7206709729358765/search/{name}")  //api/access-token/search/nombre-del-superheroe
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse> // Cuando usamos una función con Corrutinas, estas comienzan con la palabra 'suspend'
}