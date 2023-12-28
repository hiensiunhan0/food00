package com.example.food.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food.databinding.PopularItemsBinding

class PopularAdapter ( private val items:List<String>,private val price:List<String>,private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PouplerViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
        return PouplerViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items [position]
        val images = image [position]
        val price = price[position]
        holder.bind(item,price,images)


    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PouplerViewHolder (private val binding: PopularItemsBinding) : RecyclerView.ViewHolder(binding.root) {
       private val imagesView = binding.imageView6
        fun bind(item: String,price: String, images: Int) {
            binding.foodnamefopular.text = item
            binding.pricepopular.text = price
            imagesView.setImageResource(images)

        }

    }

}
