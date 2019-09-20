package com.example.recetas_cocina_prueba.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recetas_cocina_prueba.data.Receta

class RecetaViewModel: ViewModel() {
    val recetaSeleccionada: MutableLiveData<Receta> = MutableLiveData()

    fun setReceta(receta: Receta) {
        recetaSeleccionada.value = receta
    }
}