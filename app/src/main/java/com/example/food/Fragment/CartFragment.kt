package com.example.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food.R
import com.example.food.adaptar.CartAdapter
import com.example.food.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater, container,false)
        // Inflate the layout for this fragment



        val cartfoodname = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val cartitemPrice = listOf( "3đ", "12đ", "4đ", "5đ", "3đ", "8đ")
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )
        val adapter = CartAdapter(ArrayList(cartfoodname), ArrayList(cartitemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}