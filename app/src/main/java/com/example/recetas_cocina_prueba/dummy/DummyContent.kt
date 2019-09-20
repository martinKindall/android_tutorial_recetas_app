package com.example.recetas_cocina_prueba.dummy

import com.example.recetas_cocina_prueba.data.Receta


object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: List<Receta> = listOf(
        Receta(
            "Tacos mexicanos",
            "Con tortillas de maíz",
            "https://tacos10.com/storage/2018/12/Tortillas-para-tacos-mexicanos.jpg"
        ),
        Receta(
            "Arroz Chaufa",
            "Plato peruano",
            "https://cde.peru.com//ima/0/1/8/7/9/1879915/924x530/gastronomia.jpg"
        ),
        Receta(
            "Tomaticán",
            "Plato chileno",
            "https://www.midiariodecocina.com/wp-content/uploads/2016/02/Tomatican01.jpg"
        ),
        Receta(
            "Milanesa",
            "Plato argentino",
            "https://cdn.kiwilimon.com/recetaimagen/4059/th5-640x426-4238.jpg"
        )
    )
}