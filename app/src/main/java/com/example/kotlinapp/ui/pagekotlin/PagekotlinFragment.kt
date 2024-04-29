package com.example.kotlinapp.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.databinding.FragmentPagekotlinBinding
import com.example.kotlinapp.ui.pagekotlin.PagekotlinViewModel
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import com.example.kotlinapp.R
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast


class PagekotlinFragment : Fragment() {

    private var _binding: FragmentPagekotlinBinding? = null
    private val SEARCH_PATH = "/search?q="
    private val BASE_URL: String = "https://kotlinlang.org/"
    private val GOOGLE: String = "https://Google.com/"
    private var textpage : EditText? = null
    private var webView : WebView? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pagekotlinViewModel = ViewModelProvider(this).get(PagekotlinViewModel::class.java)

        _binding = FragmentPagekotlinBinding.inflate(inflater, container, false)
        //val root: View = binding.root

        val textView: TextView = binding.textpage
        pagekotlinViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val root = inflater.inflate(R.layout.fragment_pagekotlin, container, false)

        //textpage = root.findViewById(R.id.textpage)

        webView = root.findViewById(R.id.webView)
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.javaScriptEnabled = true
        webView?.loadUrl(BASE_URL)
        webView?.webViewClient = WebViewClient()
        webView?.webChromeClient = WebChromeClient()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}       // Configurar el SearchView
     /*   val mySearchView: SearchView = root.findViewById(R.id.searchview)
        mySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                          if (URLUtil.isValidUrl(query)) {
                            // Cargar la URL en el WebView
                            myWebView.loadUrl(query)
                        } else {
                            // Si no es una URL válida, agregar un prefijo y cargar la búsqueda en Google
                            myWebView.loadUrl(GOOGLE + SEARCH_PATH + query)
                            }
                        return true
                        }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })*/







