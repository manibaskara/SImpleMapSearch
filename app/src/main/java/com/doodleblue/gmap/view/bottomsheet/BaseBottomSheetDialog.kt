package com.doodleblue.gmap.view.bottomsheet

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.doodleblue.gmap.view.iview.IDailogView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

abstract class BaseBottomSheetDialog<B : ViewDataBinding>(context: Context) : BottomSheetDialog(context) , IDailogView {

    protected var bViewDataBinding: B? = null

    abstract fun bindDataToView(data: Any)

    init {
        bViewDataBinding = DataBindingUtil.bind<ViewDataBinding>(LayoutInflater.from(context).inflate(getLayoutId(), null)) as B
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(bViewDataBinding?.root)
        onViewCreated()
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(resId: Int) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show()
    }


    override fun showSnackBar(message: String) {
        if (bViewDataBinding?.root != null) {
            val snackbar = Snackbar.make(bViewDataBinding?.root!!, message, Snackbar.LENGTH_LONG)
            snackbar.setActionTextColor(Color.RED)
            snackbar.show()
        }
    }

    override fun showSnackBar(view: View, message: String) {
        val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackBar.setActionTextColor(Color.RED)
        snackBar.show()
    }
}