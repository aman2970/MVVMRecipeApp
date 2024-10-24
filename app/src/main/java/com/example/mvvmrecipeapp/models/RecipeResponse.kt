package com.example.mvvmrecipeapp.models

data class RecipeResponse(
    val limit: Int,
    val recipes: List<Recipe>,
    val skip: Int,
    val total: Int
)