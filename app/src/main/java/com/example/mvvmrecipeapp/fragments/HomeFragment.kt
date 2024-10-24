package com.example.mvvmrecipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmrecipeapp.R
import com.example.mvvmrecipeapp.adapter.RecipeAdapter
import com.example.mvvmrecipeapp.databinding.FragmentHomeBinding
import com.example.mvvmrecipeapp.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var _binding:FragmentHomeBinding

    private val binding get() = _binding

    private val viewModel : RecipeViewModel by viewModels()

    private lateinit var recipeAdapter:RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    private fun setUpRv() {
        recipeAdapter = RecipeAdapter()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            setHasFixedSize(true)
            adapter = recipeAdapter
        }

        viewModel.recipeResponse.observe(requireActivity()) { response ->
            recipeAdapter.recipe = response.recipes
        }

    }
}