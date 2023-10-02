package com.catnip.challange3.fragmentdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.catnip.challange3.databinding.FragmentDetailBinding
import com.catnip.challange3.model.DetailMenu

class FragmentDetail : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: FragmentDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetailMenuData()

        binding.tvLocationDetail.setOnClickListener {
            openGoogleMaps()
        }
    }

    private fun openGoogleMaps() {
        val gmmIntentUri = Uri.parse("https://maps.app.goo.gl/h4wQKqaBuXzftGK77")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        startActivity(mapIntent)
    }


    private fun showDetailMenuData() {
        val detailmenu = args.detailmenu
        binding.apply {
            ivBannerDetail.load(detailmenu?.imgUrl) {
                crossfade(true)
            }
            tvHeadlineMenu.text = detailmenu?.name
            tvDescriptionMenu.text = detailmenu?.desc
            tvPriceDetail.text = detailmenu?.price.toString()
        }
    }
}
