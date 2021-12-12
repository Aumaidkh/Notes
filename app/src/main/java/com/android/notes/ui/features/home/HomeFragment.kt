package com.android.notes.ui.features.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.notes.R
import com.android.notes.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.bind(view)
    }
}