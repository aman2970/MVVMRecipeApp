package com.example.mvvmrecipeapp.repository

import com.example.mvvmrecipeapp.api.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getRecipe() = apiService.getRecipe()
}