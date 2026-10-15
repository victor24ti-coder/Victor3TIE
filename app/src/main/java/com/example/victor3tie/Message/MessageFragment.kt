package com.example.victor3tie.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.victor3tie.R
import com.example.victor3tie.databinding.FragmentMessageBinding

class MessageFragment : Fragment(R.layout.fragment_message) {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMessageBinding.bind(view)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
