package com.doodleblue.gmap.view.activity

import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.text.style.StyleSpan
import android.view.View
import android.widget.LinearLayout
import com.doodleblue.gmap.R
import com.doodleblue.gmap.adapter.SearchResultAdapter
import com.doodleblue.gmap.adapter.listener.SearchResultListener
import com.doodleblue.gmap.databinding.ActivityMapBinding
import com.doodleblue.gmap.presenter.SearchLocationPresenter
import com.doodleblue.gmap.presenter.ipresenter.ISearchLocationPresenter
import com.doodleblue.gmap.view.iview.ICloseSearchListener
import com.doodleblue.gmap.view.iview.ISaveLocationListener
import com.doodleblue.gmap.view.iview.ISearchLocationView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.material.bottomsheet.BottomSheetBehavior


class SearchLocationActivity : BaseActivity<ActivityMapBinding, ISearchLocationPresenter>(),
    ISearchLocationView, OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>? = null
    private var mapFragment: SupportMapFragment? = null
    private lateinit var mMap: GoogleMap

    override fun getLayoutId(): Int {
        return R.layout.activity_map
    }

    override fun onInitializePresenter(): ISearchLocationPresenter {

        return SearchLocationPresenter(this)
    }

    override fun onPresenterCreated() {
        bViewDataBinding?.edtSearch?.addTextChangedListener(onTextChangeWatcher)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(bViewDataBinding?.bottomSheetLayout)
        bViewDataBinding?.closeButtonListener = closeButtonListener
        bViewDataBinding?.saveLocationListener = saveLocationListener
        collapseBottomsheet()
        mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment?.getMapAsync(this)

        bottomSheetBehavior?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })

    }

    private var onTextChangeWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            iPresenter?.getLocationApi(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }

    private var closeButtonListener = object : ICloseSearchListener {
        override fun onClick() {
            iPresenter?.onCloseSearchButton()
        }
    }

    private var saveLocationListener = object : ISaveLocationListener {
        override fun onClick() {
            iPresenter?.onSaveLocationButton()
        }
    }

    override fun showSearchResultBottomSheet(
        locationList: MutableList<AutocompletePrediction>,
        listener: SearchResultListener
    ) {
        bViewDataBinding?.isSearchResult = true
        val rvSearchResult = bViewDataBinding?.rvResult
        rvSearchResult?.adapter = SearchResultAdapter(locationList, listener)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        mMap.setOnMarkerClickListener(this)
    }

    override fun expandBottomSheet() {
        bottomSheetBehavior?.peekHeight = 200
        bottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun collapseBottomsheet() {
        bottomSheetBehavior?.peekHeight = 56
        bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun setMarkerOnMap(latLong: LatLng, place: AutocompletePrediction) {
        bViewDataBinding?.selectedLocation = place
        mMap.clear()
        mMap.addMarker(
            MarkerOptions().position(latLong).title(place.getFullText(StyleSpan(Typeface.BOLD)).toString())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
        )
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(latLong, 20.0f)
        )
    }

    override fun resetSearchView() {
        bViewDataBinding?.edtSearch?.setText("")
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        iPresenter?.onMarkerClick()
        return true
    }

    override fun showSelectedAddressBottomSheet() {
        bViewDataBinding?.isSearchResult = false
        bViewDataBinding?.tvAddress?.text =
            bViewDataBinding?.selectedLocation?.getFullText(StyleSpan(Typeface.BOLD)).toString()
    }
}