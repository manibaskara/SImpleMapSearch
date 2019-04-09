package com.doodleblue.gmap.view.activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.doodleblue.gmap.presenter.ipresenter.IPresenter
import com.doodleblue.gmap.util.CodeSnippet
import com.doodleblue.gmap.view.iview.IView

abstract class BaseActivity<B : ViewDataBinding, T : IPresenter> : AppCompatActivity(), IView {
    protected var bViewDataBinding: B? = null
    protected var iPresenter: T? = null
    protected var mParentView: View? = null
    private var mCodeSnippet: CodeSnippet? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        iPresenter = onInitializePresenter()
        iPresenter?.onCreate(intent.extras)
        if (iPresenter != null)
            onPresenterCreated()
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun getActivity(): FragmentActivity {
        return this@BaseActivity
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        mParentView = window.decorView.findViewById(android.R.id.content)
        return super.onCreateView(name, context, attrs)
    }

    override fun hideKeyboard() {
        val imm = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mParentView?.windowToken, 0)
    }

    abstract fun getLayoutId(): Int

    abstract fun onInitializePresenter(): T

    override val codeSnippet: CodeSnippet
        get() {
            if (mCodeSnippet == null) {
                mCodeSnippet = CodeSnippet(this.getActivity())
                return mCodeSnippet!!
            } else {
                return mCodeSnippet!!
            }
        }
}