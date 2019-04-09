package com.doodleblue.gmap.presenter.ipresenter


interface ISearchLocationPresenter : IPresenter {

    fun getLocationApi(inputText : String)

    fun onMarkerClick()

    fun onCloseSearchButton()

    fun onSaveLocationButton()

}