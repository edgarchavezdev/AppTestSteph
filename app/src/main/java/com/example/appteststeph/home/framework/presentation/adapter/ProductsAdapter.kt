package com.edgarchavezdev.CodeChallengeAndroidEKT.home.module.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appteststeph.databinding.ItemProductBinding
import com.example.appteststeph.home.domain.models.BrandItem


class ProductsAdapter(
    private val productsList: List<BrandItem>
) :
    RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    class ProductHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: BrandItem
        ) {
            binding.item = item
        }
    }
}