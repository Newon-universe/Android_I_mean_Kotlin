package com.softsquared.template.kotlin.src.main.my

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyMainBinding
import com.softsquared.template.kotlin.src.main.my.myOptions.MyOptionsFragment
import com.softsquared.template.kotlin.src.main.my.myProfile.MyProfileFragment
import com.softsquared.template.kotlin.src.main.my.myShop.MyShopFragment


class MyMainFragment : BaseFragment<FragmentMyMainBinding>(FragmentMyMainBinding::bind, R.layout.fragment_my_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val pagerAdapter = MyMainPagerFragmentAdapter(requireActivity())
        pagerAdapter.addFragment(MyShopFragment())
        pagerAdapter.addFragment(MyProfileFragment())


        val viewPager = binding.myPager

        viewPager.adapter = pagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
        viewPager.isUserInputEnabled = false

        val tabLayout = binding.myMainTabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "내 쇼핑"
                }
                1 -> tab.text = "내 프로필"
            }
        }.attach()
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"))

        binding.myMainOptions.setOnClickListener {
            val bottomSheet = MyOptionsFragment()
            bottomSheet.show(requireFragmentManager(), bottomSheet.tag)
        }

    }

}