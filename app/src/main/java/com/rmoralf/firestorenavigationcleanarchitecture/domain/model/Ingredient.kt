package com.rmoralf.firestorenavigationcleanarchitecture.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Ingredient(
    var item: String? = null,
    var amount: String? = null,
    var unit: String? = null
) : Parcelable