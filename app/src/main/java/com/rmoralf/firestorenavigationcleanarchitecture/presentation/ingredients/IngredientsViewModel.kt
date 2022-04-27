package com.rmoralf.firestorenavigationcleanarchitecture.presentation.ingredients

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.INGREDIENTS
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Ingredient
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.navparams.IngredientsParams
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IngredientsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<Response<List<Ingredient>>>(Response.Loading)
    val state: State<Response<List<Ingredient>>> = _state

    init {
        viewModelScope.launch {
            savedStateHandle.get<IngredientsParams>(INGREDIENTS)?.let {
                _state.value = Response.Success(it.ingredients)
            }
        }
    }

}