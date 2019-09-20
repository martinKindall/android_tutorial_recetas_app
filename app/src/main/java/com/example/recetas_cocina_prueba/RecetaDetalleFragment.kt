package com.example.recetas_cocina_prueba


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.recetas_cocina_prueba.data.Receta
import com.example.recetas_cocina_prueba.viewModels.RecetaViewModel

class RecetaDetalleFragment : Fragment() {

    private lateinit var recetaViewModel: RecetaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recetaViewModel = activity?.run {
            ViewModelProviders.of(this).get(RecetaViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mainView = inflater.inflate(R.layout.fragment_receta_detalle, container, false)

        recetaViewModel.recetaSeleccionada.observe(this, Observer<Receta> {
            Log.d("mis_recetas", "la receta recibida es: " + it.nombre)
        })

        return mainView
    }
}
