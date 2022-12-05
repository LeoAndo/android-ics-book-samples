package com.example.fragmentdemo

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.google.android.material.snackbar.Snackbar

class MyListFragment : ListFragment() {

    companion object {
        fun newInstance() = MyListFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val objects = buildList {
            repeat(10, action = { i ->
                add(i.toString())
            })
        }
        listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, objects)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val message = requireListAdapter().getItem(position) as? (String) ?: "unknown"
        Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show()
    }
}