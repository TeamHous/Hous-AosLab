package com.hous.housaoslab.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hous.housaoslab.R
import com.hous.housaoslab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        initBotNav()
    }

    private fun initBotNav() {
        binding.botNavMain.selectedItemId = R.id.ic_bot_nav_home

        binding.botNavMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_bot_nav_home -> {
                    binding.botNavMain.background = ContextCompat.getDrawable(this, R.drawable.shape_yellow_fill_30_rectangle)
                    binding.botNavMain.itemTextColor = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_home_color)
                    binding.botNavMain.itemIconTintList = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_home_color)
                    binding.tvMain.text = "Hous-"
                    true
                }
                R.id.ic_bot_nav_rules -> {
                    binding.botNavMain.background = ContextCompat.getDrawable(this, R.drawable.shape_blue_fill_30_rectangle)
                    binding.botNavMain.itemTextColor = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_rules_color)
                    binding.botNavMain.itemIconTintList = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_rules_color)
                    binding.tvMain.text = "Hous- 규칙"
                    true
                }
                else -> {
                    binding.botNavMain.background = ContextCompat.getDrawable(this, R.drawable.shape_red_fill_30_rectangle)
                    binding.botNavMain.itemTextColor = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_profile_color)
                    binding.botNavMain.itemIconTintList = ContextCompat.getColorStateList(this, R.color.sel_bot_nav_profile_color)
                    binding.tvMain.text = "Hous- ME"
                    true
                }
            }
        }
    }
}
