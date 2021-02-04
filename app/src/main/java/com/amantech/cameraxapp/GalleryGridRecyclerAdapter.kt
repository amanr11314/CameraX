package com.amantech.cameraxapp

import android.graphics.BitmapFactory
import android.util.DisplayMetrics
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class MyGridRecyclerAdapter(
    private val files: List<String>
) : RecyclerView.Adapter<MyGridRecyclerAdapter.ViewHolder>() {

    lateinit var displayMetrics: DisplayMetrics


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item, parent, false)

        displayMetrics = parent.context.resources.displayMetrics


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img = files[position]
        val imgBitMap = BitmapFactory.decodeFile(img)
        holder.imgView.layoutParams.width = (holder.dpWidth/4).toInt()
        holder.imgView.layoutParams.height = (holder.dpWidth/4).toInt()
        holder.imgView.setImageBitmap(imgBitMap)
    }

    override fun getItemCount(): Int = files.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgView: ImageView = view.findViewById(R.id.imgGalleryItem)
        private val pxWidth = displayMetrics.widthPixels
        val dpWidth = pxWidth / displayMetrics.density
    }
}