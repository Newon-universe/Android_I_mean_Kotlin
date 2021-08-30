package com.softsquared.template.kotlin.src.main.home.home_main

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.ActivityGoodsMainBinding
import com.softsquared.template.kotlin.databinding.FragmentHomeMainBinding
import com.softsquared.template.kotlin.src.goods.GoodsMain
import com.softsquared.template.kotlin.src.main.home.home_launch.HomeLaunchFragment
import com.softsquared.template.kotlin.src.main.home.home_today.HomeTodayFragment

class HomeMainFragment: BaseFragment<FragmentHomeMainBinding>(FragmentHomeMainBinding::bind, R.layout.fragment_home_main) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = HomeMainPagerFragmentStateAdapter(requireActivity())
        pagerAdapter.addFragment(HomeTodayFragment {
            val intent: Intent = Intent(activity, GoodsMain::class.java).apply {
                putExtra("idx", it)
            }
            startActivity(intent)
        })
        pagerAdapter.addFragment(HomeLaunchFragment())


        val viewPager = binding.homePager

        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
        viewPager.isUserInputEnabled = false



        val tabLayout = binding.homeTabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "투데이"
                1 -> tab.text = "발매정보"
            }
        }.attach()
        tabLayout.pointerIcon
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))

//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?){
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//        })
    }

    private fun getTabItem(position: Int): String?{
        return when(position){
            0 -> "투데이"
            1 -> "발매정보"
            else -> null
        }
    }
}