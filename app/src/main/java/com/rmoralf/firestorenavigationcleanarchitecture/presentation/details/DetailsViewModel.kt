package com.rmoralf.firestorenavigationcleanarchitecture.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.RECIPE_REF
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<Response<Recipe>>(Response.Loading)
    val state: State<Response<Recipe>> = _state

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(RECIPE_REF)?.let { recipeRef ->
                getProjectDetails(recipeRef)
            }
        }
    }

    private fun getProjectDetails(recipeRef: String) {
        viewModelScope.launch {
            useCases.getRecipeDetails(recipeRef).collect { projectDetails ->
                _state.value = projectDetails
            }
        }
    }

}