package com.softsquared.template.kotlin.src.main.home.home_main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
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
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
        viewPager.isUserInputEnabled = false



        val tabLayout = binding.homeTabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "투데이"
                }
                1 -> {
                    tab.text = "발매정보"
                }
            }
        }.attach()

        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))

    }


}