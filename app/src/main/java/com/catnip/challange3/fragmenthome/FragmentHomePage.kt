// FragmentHomePage.kt
package com.catnip.challange3.fragmenthome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.catnip.challange3.data.MenuDataSource
import com.catnip.challange3.data.MenuDataSourceImpl
import com.catnip.challange3.databinding.FragmentHomePageBinding
import com.catnip.challange3.fragmenthome.adapter.AdapterLayoutMode
import com.catnip.challange3.fragmenthome.adapter.FragmentHomePageAdapter
import com.catnip.challange3.model.DetailMenu

class FragmentHomePage : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    private val datasource: MenuDataSource by lazy {
        MenuDataSourceImpl()
    }
    private val adapter: FragmentHomePageAdapter by lazy {
        FragmentHomePageAdapter(AdapterLayoutMode.GRID) { detailMenu: DetailMenu ->
            navigateToDetail(detailMenu)
        }
    }

    private fun navigateToDetail(detailmenu: DetailMenu) {
        val action = FragmentHomePageDirections.actionFragmentHomePageToFragmentDetail(detailmenu)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        val layoutManager = GridLayoutManager(requireContext(), 2) // 2 adalah jumlah kolom
        binding.rvMenu.layoutManager = layoutManager
        binding.rvMenu.adapter = adapter
        adapter.submitData(datasource.getDetailMenu())
    }
}
