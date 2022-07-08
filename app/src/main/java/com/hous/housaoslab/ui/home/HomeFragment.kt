package com.hous.housaoslab.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hous.housaoslab.R
import com.hous.housaoslab.databinding.FragmentHomeBinding
import com.hous.housaoslab.ui.home.model.ComingUpAdapter
import com.hous.housaoslab.ui.home.model.ComingUpData
import com.hous.housaoslab.ui.home.model.RulesAdapter
import com.hous.housaoslab.ui.home.model.RulesData

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!
    private lateinit var comingUpAdapter: ComingUpAdapter
    private lateinit var rulesAdapter: RulesAdapter

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
                ComingUpData(R.drawable.shape_yellow_bg_fill_16_rectangle, R.drawable.img_coming_up_plus, "D-1"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-4"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-6"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-10"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-15"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-18"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-20"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-25"),
                ComingUpData(R.drawable.shape_yellow_fill_16_rectangle, R.drawable.img_coming_up_party, "D-80"),
            )
        )
        comingUpAdapter.notifyDataSetChanged()

        rulesAdapter = RulesAdapter()
        binding.rvHomeRules.adapter = rulesAdapter

        rulesAdapter.rulesList.addAll(
            listOf(
                RulesData("00시~ 불 끄기!"),
                RulesData("23시~ 이어폰 필수!"),
                RulesData("세탁기는 화,수,토"),
                RulesData("일 - 청소하는 날!"),
                RulesData("2,4주 토- 장보기"),
            )
        )
        comingUpAdapter.notifyDataSetChanged()
    }
}