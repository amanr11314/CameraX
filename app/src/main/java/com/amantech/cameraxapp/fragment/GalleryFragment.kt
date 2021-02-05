package com.amantech.cameraxapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.amantech.cameraxapp.adapter.GalleryGridRecyclerAdapter
import com.amantech.cameraxapp.R
import java.io.File

class GalleryFragment : Fragment() {

    private var columnCount = 4
    private val filePathStrings = mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        fetchImages()
        if (view is RecyclerView) {
            with(view) {
                layoutManager = GridLayoutManager(context, columnCount)

                adapter = GalleryGridRecyclerAdapter(filePathStrings)
            }
        }
        return view


    }

    private fun getOutputDirectory(): File {
        val mediaDir = (activity)!!.externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else (activity)!!.filesDir
    }

    fun fetchImages() {
        val appDIR = getOutputDirectory()

        val allFiles = appDIR.listFiles()
//        val filePathStrings = mutableListOf<String>()
        allFiles!!.forEach {
            filePathStrings.add(it!!.absolutePath)
        }
        if (filePathStrings.isEmpty()) {
            Toast.makeText(activity as Context, "Unable to read images...", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(
                activity as Context,
                "First Image Path: " + allFiles[0].absolutePath,
                Toast.LENGTH_LONG
            ).show()
        }

    }


}