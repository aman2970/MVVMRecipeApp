package com.example.mvvmrecipeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.mvvmrecipeapp.R
import com.example.mvvmrecipeapp.databinding.FragmentWebViewBinding
import com.example.mvvmrecipeapp.models.Recipe

class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private lateinit var _binding:FragmentWebViewBinding

    private val binding get() = _binding

    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var recipie:Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipie = args.recipeWebView

        setUpTextView()

    }

    private fun setUpTextView(){
        binding.textView.text = recipie.rating.toString()
    }

}