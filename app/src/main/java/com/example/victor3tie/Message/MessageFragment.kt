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

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatar.iran.liara.run/public/1"),
        MessageModel("Budi", "Sudah makan?", "https://avatar.iran.liara.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatar.iran.liara.run/public/3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatar.iran.liara.run/public/4"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatar.iran.liara.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatar.iran.liara.run/public/6"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatar.iran.liara.run/public/7"),
        MessageModel("Hana", "Lihat email ya", "https://avatar.iran.liara.run/public/8"),
        MessageModel("Irfan", "Oke noted", "https://avatar.iran.liara.run/public/9"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatar.iran.liara.run/public/10")
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMessageBinding.bind(view)

        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItem.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
