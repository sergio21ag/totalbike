package com.azarquiel.totalbike.model

import java.io.Serializable

data class Bike(
    var idbike: Int,
    var marca: String,
    var modelo: String,
    var estado: String,
    var descripcion: String,
    var precio: String
):Serializable

data class Usuario (
    var idusuario: Int,
    var nick: String,
    var pass: String,
    var telefono: String,
    var email:String
):Serializable

data class Puntos(
    var id: Int,
    var idusuario: Int,
    var idbike: Int,
    var puntos: Int
)

data class Respuesta (
    val bike: Bike,
    val bikes: List<Bike>,
    val usuario: Usuario,
    val puntos: Puntos,
    val avg: String,
    val msg: String
)