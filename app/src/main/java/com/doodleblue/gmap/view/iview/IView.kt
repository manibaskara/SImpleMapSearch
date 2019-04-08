package com.doodleblue.gmap.view.iview

import androidx.fragment.app.FragmentActivity

interface IView {
    fun showMessage(message: String)
    fun getActivity(): FragmentActivity?

}