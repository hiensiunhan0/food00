package com.example.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food.R
import com.example.food.adaptar.MenuAdapter
import com.example.food.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val orignalMenuFoodName = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo", "sandwich", "momo", "item", "sandwich", "momo")
    private val orignalMenuItemsPrice = listOf( "3đ", "12đ", "4đ", "5đ", "3đ", "8đ", "12đ", "4đ", "5đ", "3đ", "8đ")
    private val origanlMenuImage = listOf(
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuPrice,filteredMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup for search view
        setupSearchView()
        //show allmenuitem
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(orignalMenuFoodName)
        filteredMenuPrice.addAll(orignalMenuItemsPrice)
        filteredMenuImage.addAll(origanlMenuImage)

        adapter.notifyDataSetChanged()

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {


        orignalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuPrice.add(orignalMenuItemsPrice[index])
                filteredMenuImage.add(origanlMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}