package com.amantech.cameraxapp.adapter

import android.graphics.BitmapFactory
import android.util.DisplayMetrics
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.amantech.cameraxapp.R

class GalleryGridRecyclerAdapter(
    private val files: List<String>
) : RecyclerView.Adapter<GalleryGridRecyclerAdapter.ViewHolder>() {

    lateinit var displayMetrics: DisplayMetrics

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_gallery_item, parent, false)

        displayMetrics = parent.context.resources.displayMetrics
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //get imagePath
        val img = files[position]
        //decode bitmap image
        val imgBitMap = BitmapFactory.decodeFile(img)

        //setting image ascpect ratio 0.25*0.25 of screen width
        val IMAGE_SCREEN_WIDTH_RATIO = 0.25f;

        //get actual screen width
        val screenWidth = displayMetrics.widthPixels

        //define imageViewSize w.r.t aspect ratio
        val imageViewSize: Int = ((screenWidth * IMAGE_SCREEN_WIDTH_RATIO).toFloat()).toInt()

        //changing image width and height
        val params = holder.imgView.layoutParams
        params.height = imageViewSize
        params.width = imageViewSize

        //put bitmap image into image view
        holder.imgView.setImageBitmap(imgBitMap)
    }

    override fun getItemCount(): Int = files.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.imgGalleryItem)
    }
}