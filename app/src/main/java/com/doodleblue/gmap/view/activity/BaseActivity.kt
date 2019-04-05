package com.doodleblue.gmap.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doodleblue.gmap.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}