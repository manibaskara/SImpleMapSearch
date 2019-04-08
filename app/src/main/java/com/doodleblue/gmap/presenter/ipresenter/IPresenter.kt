package com.doodleblue.gmap.presenter.ipresenter

import android.os.Bundle
import com.doodleblue.gmap.model.imodel.IRepositoryModel

interface IPresenter : IRepositoryModel {

    fun onCreate(bundle: Bundle?)
}