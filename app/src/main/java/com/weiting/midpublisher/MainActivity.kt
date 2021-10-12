package com.weiting.midpublisher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.weiting.midpublisher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val adapter = ArticalRecyclerView()
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.requestData.observe(this) {
            adapter.submitList(it)
        }

        binding.rvArticle.adapter = adapter
        setContentView(binding.root)
    }
}