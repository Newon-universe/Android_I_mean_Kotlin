package com.softsquared.template.kotlin.src.main.shop

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentShopBinding
import com.softsquared.template.kotlin.src.main.shop.models.ResponseShopTop

class ShopFragment : BaseFragment<FragmentShopBinding>(FragmentShopBinding::bind, R.layout.fragment_shop), ShopFragmentView {


    private var myHandler = MyHandler()
    private val intervalTime = 2000.toLong()
    private var currentPosition = Int.MAX_VALUE / 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ShopService(this).tryGetShopTop()

    }

    override fun onGetShopTopSuccess(response: ResponseShopTop) {
        val shopAdvertisementList: List<String> = response.result.banner

        val shopAdPager = binding.shopAdvertisementViewpager
        shopAdPager.adapter = ShopAdViewpagerAdapter(shopAdvertisementList)
        shopAdPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        shopAdPager.setCurrentItem(currentPosition, false)
        shopAdPager.apply{
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when(state){
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }
    }

    private inner class MyHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val shopAdPager = binding.shopAdvertisementViewpager
            if(msg.what == 0){
                shopAdPager.setCurrentItem(++currentPosition, true)
                autoScrollStart(intervalTime)
            }
        }
    }


    private fun autoScrollStart(intervalTime: Long){
        myHandler.removeMessages(0)
        myHandler.sendEmptyMessageDelayed(0, intervalTime)
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0)
        val shopAdPager = binding.shopAdvertisementViewpager
        currentPosition = shopAdPager.currentItem
    }


    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    override fun onPause() {
        super.onPause()
        val homeTodayAdPager = binding.shopAdvertisementViewpager
        homeTodayAdPager.currentItem = currentPosition + 1
        autoScrollStop()
    }


    override fun onGetShopTopFailure(response: String) {
    }
}

