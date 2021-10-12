package com.weiting.midpublisher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weiting.midpublisher.database.ArticleData
import com.weiting.midpublisher.databinding.ArticalRowBinding

class ArticleRecyclerViewAdapter :
    ListAdapter<ArticleData, ArticleRecyclerViewAdapter.ArticalViewHolder>(Diffcallback) {
    class ArticalViewHolder(private val binding: ArticalRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articleData: ArticleData) {
            binding.articalData = articleData

            when (articleData.category) {
                "Beauty" -> {
                    binding.tvTag.setTextColor(application.getColor(R.color.green))
                }
                "Gossiping" -> {
                    binding.tvTag.setTextColor(application.getColor(R.color.blue))
                }
                "IU" -> {
                    binding.tvTag.setTextColor(application.getColor(R.color.purple_500))
                }
                else -> {
                    binding.tvTag.setTextColor(application.getColor(R.color.black))
                }
            }

        }
    }

    object Diffcallback : DiffUtil.ItemCallback<ArticleData>() {
        override fun areItemsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean =
            oldItem.id == newItem.id

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticalViewHolder {
        return ArticalViewHolder(
            ArticalRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticalViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}