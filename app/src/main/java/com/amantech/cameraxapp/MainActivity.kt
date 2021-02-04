package com.amantech.cameraxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openCamera()
    }

    private fun openCamera() {
        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            CameraPreviewFragment()
        ).commit()
    }

    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.frame)) {
            !is CameraPreviewFragment -> openCamera()
            else -> super.onBackPressed()
        }
    }
}