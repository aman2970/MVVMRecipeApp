package com.example.mvvmrecipeapp.api

import com.example.mvvmrecipeapp.models.RecipeResponse
import com.example.mvvmrecipeapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getRecipe() : Response<RecipeResponse>


}