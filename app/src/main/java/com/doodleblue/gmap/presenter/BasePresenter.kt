package com.doodleblue.gmap.presenter

import android.os.Bundle
import com.doodleblue.gmap.presenter.ipresenter.IPresenter
import com.doodleblue.gmap.view.iview.IView

abstract class BasePresenter<T : IView>(protected var iView: T?) : IPresenter {


    override fun onCreate(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        iView?.showMessage(message)
    }

}
