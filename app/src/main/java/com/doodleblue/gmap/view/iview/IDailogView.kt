package com.doodleblue.gmap.view.iview

import android.view.View

interface IDailogView {
    fun showMessage(message: String)

    fun showMessage(resId: Int)

    fun showSnackBar(message: String)

    fun showSnackBar(view: View, message: String)

    fun onViewCreated()
}