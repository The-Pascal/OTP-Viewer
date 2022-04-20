package com.solvabit.otpviewer.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.solvabit.otpviewer.R
import com.solvabit.otpviewer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.homeToolbar)
        binding.homeToolbar.title = "Messages"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_filter_menu,menu)

        val searchItem = menu.findItem(R.id.app_bar_search_message)
        val searchView = searchItem.actionView as SearchView
        initializeSearch(searchView)
    }

    private fun initializeSearch(searchView: SearchView) {
        // TODO: Implement search
    }
}