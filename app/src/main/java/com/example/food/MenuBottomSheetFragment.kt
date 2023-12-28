package com.example.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food.adaptar.MenuAdapter
import com.example.food.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuFoodName = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo", "sandwich", "momo", "item", "sandwich", "momo")
        val menuItemsPrice = listOf( "3đ", "12đ", "4đ", "5đ", "3đ", "8đ", "12đ", "4đ", "5đ", "3đ", "8đ")
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )
        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemsPrice),
            ArrayList(menuImage)
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
    }


    companion object {

    }
}