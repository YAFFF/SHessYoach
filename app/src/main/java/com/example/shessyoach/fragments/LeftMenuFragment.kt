package com.example.shessyoach.fragments

import MenuAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shessyoach.R
import com.example.shessyoach.data_control.MenuItems

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LeftMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LeftMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_left_menu, container, false)

        // Инициализация MenuItems и RecyclerView
        val menuItems = MenuItems(requireContext())
        val recyclerView: RecyclerView = view.findViewById(R.id.menu_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Использование вашего MenuAdapter
        val adapter = MenuAdapter(requireContext(), menuItems)
        recyclerView.adapter = adapter

        return view
    }
}