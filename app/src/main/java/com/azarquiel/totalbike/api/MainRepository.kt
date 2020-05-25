package com.azarquiel.totalbike.api

import com.azarquiel.totalbike.model.Bike

class MainRepository {

    val service = WebAccess.bikeService

    suspend fun getDataBikes(): List<Bike> {
        val webResponse = service.getDataBikes().await()
        if (webResponse.isSuccessful) {
            return webResponse.body()!!.bikes
        }
        return emptyList()
    }

    suspend fun saveBike(
        marca: String,
        modelo: String,
        estado: String,
        descripcion: String,
        precio: String
    ): Bike? {
        var bike: Bike? = null
        val webResponse = service.saveBike(marca, modelo, estado, descripcion, precio).await()
        if (webResponse.isSuccessful) {
            bike = webResponse.body()!!.bike
        }
        return bike
    }

}