package com.weiting.midpublisher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weiting.midpublisher.database.ArticalData
import com.weiting.midpublisher.databinding.ArticalRowBinding

class ArticalRecyclerView :
    ListAdapter<ArticalData, ArticalRecyclerView.ArticalViewHolder>(Diffcallback) {
    class ArticalViewHolder(private val binding: ArticalRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articalData: ArticalData) {
            binding.articalData = articalData
        }
    }

    object Diffcallback : DiffUtil.ItemCallback<ArticalData>() {
        override fun areItemsTheSame(oldItem: ArticalData, newItem: ArticalData): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: ArticalData, newItem: ArticalData): Boolean =
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