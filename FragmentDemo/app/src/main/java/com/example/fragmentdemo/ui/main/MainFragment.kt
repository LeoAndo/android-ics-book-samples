package com.example.fragmentdemo.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragmentdemo.MyDialogFragment
import com.example.fragmentdemo.MyListFragment
import com.example.fragmentdemo.R

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.message)
        val butonShowDialog = view.findViewById<Button>(R.id.showDialog)
        button.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MyListFragment.newInstance())
                .commitNow()
        }
        butonShowDialog.setOnClickListener {
            MyDialogFragment.newInstance().show(childFragmentManager, MyDialogFragment.TAG)
        }
    }
}