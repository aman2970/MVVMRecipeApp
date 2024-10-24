package com.example.mvvmrecipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.mvvmrecipeapp.R
import com.example.mvvmrecipeapp.databinding.FragmentDetailsBinding
import com.example.mvvmrecipeapp.models.Recipe

class DetailsFragment : Fragment() {
    private lateinit var _binding:FragmentDetailsBinding

    private val binding get() = _binding

    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var recipe:Recipe


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = args.recipe
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            ingredientsTextView.text = recipe.ingredients[0]
            titleTextView.text = recipe.name
            imageView.load(recipe.image) {
                crossfade(true)
                crossfade(1000)
            }

            button.setOnClickListener{ mView ->
                val direction = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(recipe)
                mView.findNavController().navigate(direction)
            }
        }
    }
}