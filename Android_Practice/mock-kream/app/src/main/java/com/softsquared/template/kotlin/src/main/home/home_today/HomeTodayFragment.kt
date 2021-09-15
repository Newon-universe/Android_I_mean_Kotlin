package com.softsquared.template.kotlin.src.main.home.home_today

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayBinding
import com.softsquared.template.kotlin.src.main.home.home_today.models.*

data class GoodsList(val name: String?, val brand:String?,  val brandImage:String?, val category:String?, val image: String, val title:String, val price:String)
data class GoodsOthersList(val image: String, val brand: String, val title:String, val price:String)
data class StylePicksList(val image:String, val profile: String, val user: String)
data class UpcomingGoodsList(val image:String, val brand:String, val title: String)

class HomeTodayFragment(private val mainIntent:(Int) -> Unit) : BaseFragment<FragmentHomeTodayBinding>(FragmentHomeTodayBinding::bind, R.layout.fragment_home_today),
    HomeTodayFragmentView {

    private var myHandler = MyHandler()
    private val intervalTime = 2000.toLong()
    private var currentPosition = Int.MAX_VALUE / 2

    private var mostPopular: MutableList<GoodsOthersList> = mutableListOf()
    private var shoeKreamTagList: MutableList<StylePicksList> = mutableListOf()
    private var koreanCollectionList: MutableList<GoodsOthersList> = mutableListOf()
    private var xOffWhiteList: MutableList<GoodsOthersList> = mutableListOf()
    private var legoList: MutableList<GoodsOthersList> = mutableListOf()
    private var streetwearsList: MutableList<GoodsOthersList> = mutableListOf()
    private var smallLeathersList: MutableList<GoodsOthersList> = mutableListOf()
    private var contemporariesList: MutableList<GoodsOthersList> = mutableListOf()
    private var luxurySneakersList: MutableList<GoodsOthersList> = mutableListOf()
    private var newLowestAsksList: MutableList<GoodsOthersList> = mutableListOf()
    private var newHighestBidsList: MutableList<GoodsOthersList> = mutableListOf()
    private var upcomingGoodsList: MutableList<UpcomingGoodsList> = mutableListOf()
    private var orcaAlternativesList: MutableList<GoodsOthersList> = mutableListOf()
    private var greyCollectionsList: MutableList<GoodsOthersList> = mutableListOf()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        HomeTodayService(this).tryGetTodayInformation()

        getMostPopular()
        binding.homeTodayMostPopularRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayMostPopularRecyclerview.adapter = HomeTodayGoodsOthersAdapter(mostPopular, mainIntent)

//        getShoeKreamList()
//        binding.homeTodayShoeKreamTagRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayShoeKreamTagRecyclerview.adapter = HomeTodayStylePickAdapter(shoeKreamTagList)

        getKoreanCollectionList()
        binding.homeTodayKoreaCollectionRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayKoreaCollectionRecyclerview.adapter = HomeTodayGoodsOthersAdapter(koreanCollectionList, mainIntent)

        getXOffList()
        binding.homeTodayXOffWhiteRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayXOffWhiteRecyclerview.adapter = HomeTodayGoodsOthersAdapter(xOffWhiteList, mainIntent)

        getLegoList()
        binding.homeTodayLegoRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayLegoRecyclerview.adapter = HomeTodayGoodsOthersAdapter(legoList, mainIntent)

        getStreetwearList()
        binding.homeTodayStreetwearRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayStreetwearRecyclerview.adapter = HomeTodayGoodsOthersAdapter(streetwearsList, mainIntent)

        getSmallLeathersList()
        binding.homeTodaySmallLeathersRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodaySmallLeathersRecyclerview.adapter = HomeTodayGoodsOthersAdapter(smallLeathersList, mainIntent)

        getContemporariesList()
        binding.homeTodayContemporaryRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayContemporaryRecyclerview.adapter = HomeTodayGoodsOthersAdapter(contemporariesList, mainIntent)

        getLuxurySneakersList()
        binding.homeTodayLuxurySneakersRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayLuxurySneakersRecyclerview.adapter = HomeTodayGoodsOthersAdapter(luxurySneakersList, mainIntent)

        getNewLowestAsksList()
        binding.homeTodayNewLowestAsksRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayNewLowestAsksRecyclerview.adapter = HomeTodayGoodsOthersAdapter(newLowestAsksList, mainIntent)

        getNewHighestBidsList()
        binding.homeTodayNewHighestBidsRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayNewHighestBidsRecyclerview.adapter = HomeTodayGoodsOthersAdapter(newHighestBidsList, mainIntent)

        getUpcomingGoodsList()
        binding.homeTodayUpcomingReleaseRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayUpcomingReleaseRecyclerview.adapter = HomeTodayUpcomingAdapter(upcomingGoodsList)

        getOrcaAlternativesList()
        binding.homeTodayOrcaAlternativesRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayOrcaAlternativesRecyclerview.adapter = HomeTodayGoodsOthersAdapter(orcaAlternativesList, mainIntent)

        getGreyCollectionsList()
        binding.homeTodayGreyCollectionRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayGreyCollectionRecyclerview.adapter = HomeTodayGoodsOthersAdapter(greyCollectionsList, mainIntent)




    }




    private fun getMostPopular() {
        with(mostPopular) {
            add(
                GoodsOthersList(
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList(
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList(
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getShoeKreamList() {
        with(shoeKreamTagList) {
            add(
                StylePicksList(
                    "${R.drawable.home_today_style_picks_style_sample}",
                    "${R.drawable.home_today_style_picks_user_sample}",
                    "@sin92"
                )
            )
            add(
                StylePicksList(
                    "${R.drawable.home_today_style_picks_style_sample}",
                    "${R.drawable.home_today_style_picks_user_sample}",
                    "@sin92"
                )
            )
            add(
                StylePicksList(
                    "${R.drawable.home_today_style_picks_style_sample}",
                    "${R.drawable.home_today_style_picks_user_sample}",
                    "@sin92"
                )
            )
        }
    }

    private fun getKoreanCollectionList() {
        with(koreanCollectionList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getXOffList() {
        with(xOffWhiteList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getLegoList() {
        with(legoList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getStreetwearList() {
        with(streetwearsList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getSmallLeathersList() {
        with(smallLeathersList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getContemporariesList() {
        with(contemporariesList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getLuxurySneakersList() {
        with(luxurySneakersList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getNewLowestAsksList() {
        with(newLowestAsksList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getNewHighestBidsList() {
        with(newHighestBidsList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getUpcomingGoodsList() {
        with(upcomingGoodsList) {
            add(
                UpcomingGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
                )
            )
            add(
                UpcomingGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
                )
            )
            add(
                UpcomingGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
                )
            )
        }
    }

    private fun getOrcaAlternativesList() {
        with(orcaAlternativesList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }

    private fun getGreyCollectionsList() {
        with(greyCollectionsList) {
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_image_sample1}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
            add(
                GoodsOthersList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}"
                )
            )
        }
    }



    override fun onGetHomeTodayInformationSuccess(response: ResponseHomeToday) {
        Log.d("1234", "${response.result}")

        val mainSlidersList: List<Mainslider> = response.result.mainslider
        val justDroppedListApi: List<JustDropped> = response.result.JustDropped
        val stylePicksListApi:List<Style> =response.result.Style

        val homeTodayAdPager = binding.homeTodayAdPager
        val homeTodayAdPagerIndicator = binding.homeTodayAdPagerIndicator

        homeTodayAdPager.adapter = HomeTodayAdAdapter(mainSlidersList)
        homeTodayAdPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        homeTodayAdPager.setCurrentItem(currentPosition, false)
        homeTodayAdPager.apply{
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

        binding.homeTodayJustDroppedRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayJustDroppedRecyclerview.adapter = HomeTodayGoodsAdapter(justDroppedListApi, mainIntent)

        binding.homeTodayStylePicksRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.homeTodayStylePicksRecyclerview.adapter = HomeTodayStylePickAdapter(stylePicksListApi)

        Glide.with(activity!!)
            .load(response.result.Banner[0].img)
            .into(binding.homeTodayAd1)
    }

    override fun onGetHomeTodayInformationFailure(response: String) {
    }

    private inner class MyHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val homeTodayAdPager = binding.homeTodayAdPager
            if(msg.what == 0){
                homeTodayAdPager.setCurrentItem(++currentPosition, true)
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
        val homeTodayAdPager = binding.homeTodayAdPager
        currentPosition = homeTodayAdPager.currentItem
    }

    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    override fun onPause() {
        super.onPause()
        val homeTodayAdPager = binding.homeTodayAdPager
        homeTodayAdPager.currentItem = currentPosition + 1
        autoScrollStop()
    }


}