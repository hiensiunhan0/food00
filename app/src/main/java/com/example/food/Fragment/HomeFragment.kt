package com.example.food.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food.MenuBottomSheetFragment
import com.example.food.R
import com.example.food.adaptar.PopularAdapter
import com.example.food.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewAllMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val foodName = listOf("Burger", "sandwich", "momo", "item")
        val Price = listOf("3đ", "12đ", "4đ", "5đ")
        val populerFoodImages =
            listOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4)
        val adapter = PopularAdapter(foodName,Price,populerFoodImages)
        binding.PopulerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopulerRecyclerView.adapter=adapter
    }

    companion object {
    }

}