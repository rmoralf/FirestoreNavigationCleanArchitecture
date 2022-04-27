package com.rmoralf.firestorenavigationcleanarchitecture.core.utils

import android.util.Log
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.TAG

class Utils {
    companion object {
        fun printError(message: String) {
            Log.d(TAG, message)
        }

        fun createSubroute(screen: String, arg: String): String {
            return "$screen/{$arg}"
        }
    }
}