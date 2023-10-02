package com.catnip.challange3.fragmenthome.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.challange3.core.ViewHolderBinder
import com.catnip.challange3.databinding.ItemGridMenuBinding
import com.catnip.challange3.databinding.ItemLinearMenuBinding
import com.catnip.challange3.model.DetailMenu

class GridMenuItemViewHolder(
    private val binding : ItemGridMenuBinding,
    private val onItemClickListener : (DetailMenu) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<DetailMenu>{
    override fun bind(item: DetailMenu) {
       binding.ivMenu.load(item.imgUrl){
           crossfade(true)
       }
        binding.tvMenuName.text = item.name
        binding.root.setOnClickListener {
            onItemClickListener.invoke(item)
        }
    }
}
class LinearMenuItemViewHolder(
    private val binding: ItemLinearMenuBinding,
    private val onCLickListener: (DetailMenu) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<DetailMenu> {
    override fun bind(item: DetailMenu) {
        binding.ivMenu.load(item.imgUrl){
            crossfade(true)
        }
        binding.tvMenuname.text = item.name
        binding.root.setOnClickListener {
            onCLickListener.invoke(item)
        }
    }
}
