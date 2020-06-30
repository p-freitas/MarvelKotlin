package com.marvelapp.br.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marvelapp.br.R
import kotlinx.android.synthetic.main.personagem_comic_list_item.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
