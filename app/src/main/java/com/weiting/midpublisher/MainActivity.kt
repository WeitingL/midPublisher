package com.weiting.midpublisher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.weiting.midpublisher.Factory.MainViewModelFactory
import com.weiting.midpublisher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        val adapter = ArticleRecyclerViewAdapter()
        val viewModelFactory =
            MainViewModelFactory(PublicApplication().firebaseDataRepository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.requestData.observe(this) {
            adapter.submitList(it)
        }

        viewModel.refreshState.observe(this) {
            if (it == false) {
                binding.swipeRefreshLayout.isRefreshing = it
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshData()
        }

        binding.imageButton.setOnClickListener {
            PublishDialog().show(supportFragmentManager, "Published")
        }

        binding.rvArticle.adapter = adapter
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
    }
}