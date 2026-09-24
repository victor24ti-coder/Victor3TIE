package com.example.victor3tie.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.victor3tie.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            // Mengambil teks dari TextInputEditText (id: inputNoTujuan)
            val nama = binding.inputNoTujuan.text.toString()

            val intent = Intent(this, ThirdResultActivity::class.java).apply {
                putExtra("EXTRA_NAMA", nama)
            }
            startActivity(intent)
        }
    }
}