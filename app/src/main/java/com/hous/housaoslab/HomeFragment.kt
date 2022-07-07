package com.hous.housaoslab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hous.housaoslab.databinding.FragmentHomeBinding
import com.hous.housaoslab.ui.home.model.ComingUpAdapter
import com.hous.housaoslab.ui.home.model.ComingUpData

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!
    private lateinit var comingUpAdapter: ComingUpAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        comingUpAdapter = ComingUpAdapter()
        binding.rvHomeComingUp.adapter = comingUpAdapter

        comingUpAdapter.comingUpList.addAll(
            listOf(
                ComingUpData(R.drawable.shape_yellow_bg_fill_16_rectangle, R.drawable.img_coming_up_plus, "D-10"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-10"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-9"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-8"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-1"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-4"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-25"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-14"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-25"),
            )
        )
        comingUpAdapter.notifyDataSetChanged()
    }
}