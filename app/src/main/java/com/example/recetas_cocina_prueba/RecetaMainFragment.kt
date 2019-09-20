package com.example.recetas_cocina_prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.recetas_cocina_prueba.data.Receta

import com.example.recetas_cocina_prueba.dummy.DummyContent


class RecetaMainFragment : Fragment() {

    private var columnCount = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recetarecycler_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = RecetaRecyclerRecyclerViewAdapter(
                    DummyContent.ITEMS,
                    object: OnListFragmentInteractionListener {
                        override fun onListFragmentInteraction(item: Receta) {
                            findNavController()
                                .navigate(R.id.action_recetaMainFragment_to_recetaDetalleFragment)
                        }
                    }
                )
            }
        }
        return view
    }
}
