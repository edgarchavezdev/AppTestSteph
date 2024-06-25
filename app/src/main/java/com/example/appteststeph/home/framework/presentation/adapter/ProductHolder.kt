package com.example.appteststeph.home.framework.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.appteststeph.databinding.ItemProductBinding
import com.example.appteststeph.home.domain.models.BrandItem

class ProductHolder(val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: BrandItem,
        listener: (BrandItem) -> Unit,
    ) {
        binding.item = item

        binding.root.setOnClickListener {
            listener(item)
        }
    }
}