package com.doodleblue.gmap.common

interface Constants {

    interface InternalHttpCode {
        companion object {
            const val FAILURE_CODE = 404
            const val BAD_REQUEST_CODE = 400
            const val UNAUTHORIZED_CODE = 401
            const val INTERNAL_SERVER_ERROR_CODE = 500
            const val TIMEOUT_CODE = 504
        }
    }

    interface HttpErrorMessage {
        companion object {
            const val INTERNAL_SERVER_ERROR = "Our server is under maintenance. We will resolve shortly!"
            const val FORBIDDEN = "Seems like you haven't permitted to do this operation!"
            const val TIMEOUT = "Unable to connect to server. Please try after sometime"
            const val UNAUTHORIZED = "UnAuthorized"
        }

    }

    interface PlacesApi {
        companion object {
            const val PLACES_API_KEY = "AIzaSyANB4Mr_JLOt6JynTMmIc88ThFRwxfay4E"
            //const val PLACES_API_KEY_1 = "AIzaSyBoxbX_SJov-mHgft-puI4vegNeTiLur4c"
        }
    }
}