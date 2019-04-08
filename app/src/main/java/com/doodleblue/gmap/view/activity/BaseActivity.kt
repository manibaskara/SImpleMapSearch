package com.doodleblue.gmap.view.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.doodleblue.gmap.presenter.ipresenter.IPresenter
import com.doodleblue.gmap.view.iview.IView

abstract class BaseActivity<B : ViewDataBinding, T : IPresenter> : AppCompatActivity(), IView {

    protected var bViewDataBinding: B? = null
    protected var iPresenter: T? = null
    protected var mParentView: View?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        iPresenter = onInitializePresenter()
        iPresenter?.onCreate(intent.extras)

    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun getActivity(): FragmentActivity? {
        return this@BaseActivity
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        mParentView =window.decorView.findViewById(android.R.id.content)
        return super.onCreateView(name, context, attrs)
    }


    abstract fun getLayoutId(): Int

    abstract fun onInitializePresenter(): T
}