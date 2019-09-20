package com.example.recetas_cocina_prueba

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.recetas_cocina_prueba.data.Receta
import kotlinx.android.synthetic.main.recycler_receta.view.*


class RecetaRecyclerRecyclerViewAdapter(
    private val mValues: List<Receta>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<RecetaRecyclerRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private var parent: ViewGroup? = null

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Receta
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_receta, parent, false)
        this.parent = parent
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Receta = mValues[position]
        holder.mIdView.text = item.nombre
        holder.mContentView.text = item.descripcion

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }

        this.parent?.let {
            Glide
                .with(it)
                .load("https://tacos10.com/storage/2018/12/Tortillas-para-tacos-mexicanos.jpg")
                .centerCrop()
                .into(holder.mImage)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.titulo
        val mContentView: TextView = mView.descripcion
        val mImage: ImageView = mView.receta_imagen

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}

interface OnListFragmentInteractionListener {
    fun onListFragmentInteraction(item: Receta)
}