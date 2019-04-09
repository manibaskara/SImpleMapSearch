package com.doodleblue.gmap.presenter

import android.graphics.Typeface
import android.os.Bundle
import android.text.style.StyleSpan
import com.doodleblue.gmap.adapter.listener.SearchResultListener
import com.doodleblue.gmap.model.ModelRepository
import com.doodleblue.gmap.presenter.ipresenter.ISearchLocationPresenter
import com.doodleblue.gmap.view.iview.ISearchLocationView
import com.google.android.libraries.places.api.model.AutocompletePrediction


class SearchLocationPresenter(var iSearchLocationView: ISearchLocationView) :

    BasePresenter<ISearchLocationView>(iSearchLocationView), ISearchLocationPresenter {


    override fun getLocationApi(inputText: String) {

        if (!inputText.isEmpty()) {

            if (isConnectedToInternet())

                iSearchLocationView.getActivity()?.let {
                    ModelRepository(it, this).getAutoCompleteDataModel(inputText)
                    iSearchLocationView.expandBottomSheet()

                }
            else {
                showNetworkUnavailable()
                iSearchLocationView.collapseBottomsheet()
            }
        } else {
            returnData(mutableListOf())
            iSearchLocationView.collapseBottomsheet()
        }
    }

    private var listener = object : SearchResultListener {
        override fun onItemClick(position: Int, data: AutocompletePrediction) {
            val latLng =
                iSearchLocationView.codeSnippet.getLocationFromAddress(data.getFullText(StyleSpan(Typeface.BOLD)).toString())
            if (latLng != null)
                iSearchLocationView.setMarkerOnMap(latLng, data)
            iSearchLocationView.hideKeyboard()
            iSearchLocationView.collapseBottomsheet()

        }
    }


    override fun onCreate(bundle: Bundle?) {
    }

    override fun isConnectedToInternet(): Boolean {
        return iSearchLocationView.codeSnippet.hasNetworkConnection()
    }

    override fun returnData(prediction: MutableList<AutocompletePrediction>) {
        iSearchLocationView.showSearchResultBottomSheet(prediction, listener)

    }

    override fun showNetworkUnavailable() {
        iView?.showMessage("Network Unavailable")
    }

    override fun onMarkerClick() {
        iView?.showSelectedAddressBottomSheet()
        iView?.expandBottomSheet()
    }

    override fun onCloseSearchButton() {
        iView?.hideKeyboard()
        iView?.resetSearchView()
        iView?.collapseBottomsheet()
    }

    override fun onSaveLocationButton() {
        showMessage("Location Saved Successfully")
    }

}