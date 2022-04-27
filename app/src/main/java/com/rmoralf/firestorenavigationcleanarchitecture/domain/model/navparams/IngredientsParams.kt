package com.rmoralf.firestorenavigationcleanarchitecture.domain.model.navparams

import android.os.Parcelable
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Ingredient
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class IngredientsParams(
    val ingredients: List<Ingredient>
) : Parcelable