package com.rmoralf.firestorenavigationcleanarchitecture.presentation.navigation.paramtypes

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.navparams.IngredientsParams

class IngredientsParamsType : NavType<IngredientsParams>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): IngredientsParams? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): IngredientsParams {
        return Gson().fromJson(value, IngredientsParams::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: IngredientsParams) {
        bundle.putParcelable(key, value)
    }
}