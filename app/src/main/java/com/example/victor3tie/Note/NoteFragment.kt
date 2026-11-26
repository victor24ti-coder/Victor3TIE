package com.example.victor3tie.Note

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.victor3tie.R
import com.example.victor3tie.data.AppDatabase
import com.example.victor3tie.data.entity.NoteEntity
import com.example.victor3tie.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class NoteFragment : Fragment(R.layout.fragment_note) {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    /** Variabel database & Adapter **/
    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNoteBinding.bind(view)

        val activity = requireActivity() as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.apply {
            title = "Note"
        }

        /** Inisialisasi AppDatabase & Adapter **/
        db = AppDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notes, this)

        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        fetchNotes()

        /** Tambah ini sebagai garis pemisah **/
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvNotes.addItemDecoration(dividerItemDecoration)

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }
    }
    private fun fetchNotes() {
        lifecycleScope.launch {
            val data = db.noteDao().getAll() //pemanggilan query
            notes.clear()
            notes.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch {
            db.noteDao().delete(note) //Hapus Note
            fetchNotes()              //Fetch lagi data notes terbaru
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
