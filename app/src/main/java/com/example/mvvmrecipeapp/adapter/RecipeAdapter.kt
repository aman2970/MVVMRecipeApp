package com.example.mvvmrecipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvmrecipeapp.databinding.RecipeLayoutAdapterBinding
import com.example.mvvmrecipeapp.fragments.HomeFragmentDirections
import com.example.mvvmrecipeapp.models.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding:RecipeLayoutAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback  = object : DiffUtil.ItemCallback<Recipe>(){
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)
    var recipe : List<Recipe>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(RecipeLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currRecipe = recipe[position]

        holder.binding.apply {
            textView.text = currRecipe.name
            imageView.load(currRecipe.image) {
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener{ mView ->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currRecipe)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int = recipe.size
}