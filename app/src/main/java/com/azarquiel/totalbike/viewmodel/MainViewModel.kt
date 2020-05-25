package com.azarquiel.totalbike.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azarquiel.totalbike.api.MainRepository
import com.azarquiel.totalbike.model.Bike
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var repository: MainRepository = MainRepository()

    fun getDataBikes(): LiveData<List<Bike>> {
        val dataBikes = MutableLiveData<List<Bike>>()
        GlobalScope.launch(Dispatchers.Main) {
            dataBikes.value = repository.getDataBikes()
        }
        return dataBikes
    }

    fun saveBike( marca: String, modelo: String,
                 estado: String, descripcion: String, precio: String): LiveData<Bike> {
        val bike= MutableLiveData<Bike>()
        GlobalScope.launch(Dispatchers.Main) {
            bike.value = repository.saveBike(marca, modelo, estado, descripcion, precio)
        }
        return bike
    }

}