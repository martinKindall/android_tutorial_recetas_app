package com.example.recetas_cocina_prueba


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
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

        recetaViewModel.recetaSeleccionada.observe(this, Observer<Receta> { receta ->
            Log.d("mis_recetas", "la receta recibida es: " + receta.nombre)

            val imagen = mainView.findViewById<ImageView>(R.id.receta_detalle_imagen)

            context?.let { context ->
                Glide
                    .with(context)
                    .load(receta.link)
                    .centerCrop()
                    .into(imagen)
            }

            mainView.findViewById<TextView>(R.id.receta_detalle_titulo)
                .text = receta.nombre
            mainView.findViewById<TextView>(R.id.receta_detalle_descripcion)
                .text = receta.descripcion
            mainView.findViewById<TextView>(R.id.receta_detalle_completa)
                .text = receta.receta
        })

        return mainView
    }
}
