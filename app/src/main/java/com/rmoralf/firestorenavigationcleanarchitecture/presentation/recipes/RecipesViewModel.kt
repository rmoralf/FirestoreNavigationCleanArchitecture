package com.rmoralf.firestorenavigationcleanarchitecture.presentation.recipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Recipe
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response
import com.rmoralf.firestorenavigationcleanarchitecture.domain.model.Response.Loading
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _recipesState = mutableStateOf<Response<List<Recipe>>>(Loading)
    val recipesState: State<Response<List<Recipe>>> = _recipesState

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch {
            useCases.getRecipes().collect { response ->
                _recipesState.value = response
            }
        }
    }

}