package com.example.victor3tie.pertemuan3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.victor3tie.R

class ThirdResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_result)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data nama yang dikirim dari Intent
        val nama = intent.getStringExtra("EXTRA_NAMA") ?: ""

        // Menampilkan pesan di Logcat
        Log.e("Klik btnSubmit", "Tombol berhasil ditekan. Isi dari inputNama = $nama")

        // Menampilkan Toast
        Toast.makeText(this, "Pesan berhasil dikirim ke $nama!", Toast.LENGTH_SHORT).show()
    }
}