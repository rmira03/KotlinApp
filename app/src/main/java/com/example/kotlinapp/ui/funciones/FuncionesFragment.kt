package com.example.kotlinapp.ui.funciones

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.FragmentFuncionesBinding
import com.example.kotlinapp.databinding.FragmentHomeBinding
import com.example.kotlinapp.ui.home.HomeViewModel

class FuncionesFragment : Fragment() {

    private var _binding: FragmentFuncionesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val funViewModel =
            ViewModelProvider(this).get(FuncionesViewModel::class.java)

        _binding = FragmentFuncionesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFun1
        funViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}