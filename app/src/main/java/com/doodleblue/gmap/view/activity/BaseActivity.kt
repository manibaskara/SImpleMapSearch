package com.doodleblue.gmap.view.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.doodleblue.gmap.R
import com.doodleblue.gmap.presenter.ipresenter.IPresenter
import com.doodleblue.gmap.view.iview.IView

class BaseActivity<B : ViewDataBinding, T : IPresenter> : AppCompatActivity(), IView {

    protected var bViewDataBinding: B? = null
    protected var iPresenter: T? = null
    protected var mParentView: View?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActivity(): FragmentActivity? {
        return this@BaseActivity
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        mParentView =window.decorView.findViewById(android.R.id.content)
        return super.onCreateView(name, context, attrs)
    }
}