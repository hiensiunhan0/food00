package com.example.food.adaptar


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.food.databinding.CartItemBinding


class CartAdapter(
    private val cartItem: MutableList<String>,
    private val CartItemPrice: MutableList<String>,
    private val CartImage: MutableList<Int>
) : RecyclerView.Adapter<CartAdapter.cartViewHolder>() {

    private val itemQuantities = IntArray(cartItem.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartViewHolder {
        val bingding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return cartViewHolder(bingding)
    }

    override fun onBindViewHolder(holder: cartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItem.size

    inner class cartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartfoodname.text = cartItem[position]
                cartitemprice.text = CartItemPrice[position]
                cartimage.setImageResource(CartImage[position])
                catitemQuantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    deceaseQuantity((position))
                }
                pluseButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }
                }


            }
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.catitemQuantity.text = itemQuantities[position].toString()
            }
        }

        private fun deceaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.catitemQuantity.text = itemQuantities[position].toString()
            }
        }

        fun deleteItem(position: Int) {
            cartItem.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItem.size)
        }

    }
}

