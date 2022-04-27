package com.rmoralf.firestorenavigationcleanarchitecture.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.rmoralf.firestorenavigationcleanarchitecture.core.utils.Constants.RECIPES
import com.rmoralf.firestorenavigationcleanarchitecture.data.repository.RecipesRepositoryImpl
import com.rmoralf.firestorenavigationcleanarchitecture.domain.repository.RecipesRepository
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.GetRecipeDetails
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.GetRecipes
import com.rmoralf.firestorenavigationcleanarchitecture.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Repositories
    @Provides
    fun provideRecipesRef(db: FirebaseFirestore) = db.collection(RECIPES)

    @Provides
    fun provideRecipesRepository(
        recipesRef: CollectionReference,
    ): RecipesRepository = RecipesRepositoryImpl(recipesRef = recipesRef)

    @Provides
    fun provideUseCases(
        recipesRepository: RecipesRepository
    ) = UseCases(
        getRecipes = GetRecipes(recipesRepository),
        getRecipeDetails = GetRecipeDetails(recipesRepository)
    )

    //Firebase
    @Provides
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()
}