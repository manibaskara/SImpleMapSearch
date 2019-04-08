package com.doodleblue.gmap.adapter.listener

import com.doodleblue.gmap.model.dto.common.Prediction
import com.google.android.libraries.places.api.model.AutocompletePrediction

interface SearchResultListener : BaseRecyclerListener<AutocompletePrediction>