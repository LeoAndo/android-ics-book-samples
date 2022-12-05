package com.example.fragmentdemo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment(R.layout.fragment_my_dialog) {
    companion object {
        fun newInstance() = MyDialogFragment()
        const val TAG = "MyDialogFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: IN hashcode: " + hashCode())
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_my_dialog, null, false)
        return AlertDialog.Builder(requireActivity()).apply {
            setTitle(" タイトル")
            setPositiveButton(android.R.string.ok, null)
            setNegativeButton(android.R.string.cancel, null)
            setView(view)
        }.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: IN hashcode: " + hashCode())
    }
}