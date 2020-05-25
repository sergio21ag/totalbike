package com.azarquiel.totalbike.api

import com.azarquiel.totalbike.model.Respuesta
import com.azarquiel.totalbike.model.Usuario
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface BikeService {

    // idbike en la url
    @GET("bike/{idbike}")
    fun getDataBike(@Path("idbike") idbike: Int): Deferred<Response<Respuesta>>

    @GET("bike")
    fun getDataBikes(): Deferred<Response<Respuesta>>


    // nick y pass como variables en la url?nick=admin&pass=admin
    @GET("usuario")
    fun getDataUsuarioPorNickPass(
        @Query("nick") nick: String,
        @Query("pass") pass: String): Deferred<Response<Respuesta>>

    // post con objeto en json
    @POST("usuario")
    fun saveUsuario(@Body usuario: Usuario): Deferred<Response<Respuesta>>

    // post con variables sueltas
    @FormUrlEncoded
    @POST("bike/{idbike}/puntos")
    fun savePuntos(@Path("idbike") idbike: Int,
                   @Field("idusuario") idusuario: Int,
                   @Field("puntos") puntos: Int): Deferred<Response<Respuesta>>

    @FormUrlEncoded
    @POST("bike")
    fun saveBike(@Field("marca") marca: String,
                @Field("modelo") modelo: String,
                @Field("estado") estado: String,
                 @Field("descripcion") descripcion: String,
                @Field("precio") precio: String
    ): Deferred<Response<Respuesta>>

}