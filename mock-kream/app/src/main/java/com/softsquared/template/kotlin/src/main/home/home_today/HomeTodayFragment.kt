package com.softsquared.template.kotlin.src.main.home.home_today

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHomeTodayBinding
import com.softsquared.template.kotlin.src.main.home.home_today.models.*

data class GoodsList(val name: String?, val brand:String?,  val brandImage:String?, val category:String?, val image: String, val title:String, val price:String)
data class StylePicksList(val image:String, val profile: String, val user: String)
data class UpcomingGoodsList(val image:String, val brand:String, val title: String)

class HomeTodayFragment(private val mainIntent:(Int) -> Unit) : BaseFragment<FragmentHomeTodayBinding>(FragmentHomeTodayBinding::bind, R.layout.fragment_home_today),
    HomeTodayFragmentView {

    private var mostPopular: MutableList<GoodsList> = mutableListOf()
    private var shoeKreamTagList: MutableList<StylePicksList> = mutableListOf()
    private var koreanCollectionList: MutableList<GoodsList> = mutableListOf()
    private var xOffWhiteList: MutableList<GoodsList> = mutableListOf()
    private var legoList: MutableList<GoodsList> = mutableListOf()
    private var streetwearsList: MutableList<GoodsList> = mutableListOf()
    private var smallLeathersList: MutableList<GoodsList> = mutableListOf()
    private var contemporariesList: MutableList<GoodsList> = mutableListOf()
    private var luxurySneakersList: MutableList<GoodsList> = mutableListOf()
    private var newLowestAsksList: MutableList<GoodsList> = mutableListOf()
    private var newHighestBidsList: MutableList<GoodsList> = mutableListOf()
    private var upcomingGoodsList: MutableList<UpcomingGoodsList> = mutableListOf()
    private var orcaAlternativesList: MutableList<GoodsList> = mutableListOf()
    private var greyCollectionsList: MutableList<GoodsList> = mutableListOf()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        HomeTodayService(this).tryGetTodayInformation()

//        getMostPopular()
//        binding.homeTodayMostPopularRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayMostPopularRecyclerview.adapter = HomeTodayGoodsAdapter(mostPopular, mainIntent)
//
//        getShoeKreamList()
//        binding.homeTodayShoeKreamTagRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayShoeKreamTagRecyclerview.adapter = HomeTodayStylePickAdapter(shoeKreamTagList)
//
//        getKoreanCollectionList()
//        binding.homeTodayKoreaCollectionRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayKoreaCollectionRecyclerview.adapter = HomeTodayGoodsAdapter(koreanCollectionList, mainIntent)
//
//        getXOffList()
//        binding.homeTodayXOffWhiteRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayXOffWhiteRecyclerview.adapter = HomeTodayGoodsAdapter(xOffWhiteList, mainIntent)
//
//        getLegoList()
//        binding.homeTodayLegoRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayLegoRecyclerview.adapter = HomeTodayGoodsAdapter(legoList, mainIntent)
//
//        getStreetwearList()
//        binding.homeTodayStreetwearRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayStreetwearRecyclerview.adapter = HomeTodayGoodsAdapter(streetwearsList, mainIntent)
//
//        getSmallLeathersList()
//        binding.homeTodaySmallLeathersRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodaySmallLeathersRecyclerview.adapter = HomeTodayGoodsAdapter(smallLeathersList, mainIntent)
//
//        getContemporariesList()
//        binding.homeTodayContemporaryRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayContemporaryRecyclerview.adapter = HomeTodayGoodsAdapter(contemporariesList, mainIntent)
//
//        getLuxurySneakersList()
//        binding.homeTodayLuxurySneakersRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayLuxurySneakersRecyclerview.adapter = HomeTodayGoodsAdapter(luxurySneakersList, mainIntent)
//
//        getNewLowestAsksList()
//        binding.homeTodayNewLowestAsksRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayNewLowestAsksRecyclerview.adapter = HomeTodayGoodsAdapter(newLowestAsksList, mainIntent)
//
//        getNewHighestBidsList()
//        binding.homeTodayNewHighestBidsRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayNewHighestBidsRecyclerview.adapter = HomeTodayGoodsAdapter(newHighestBidsList, mainIntent)
//
//        getUpcomingGoodsList()
//        binding.homeTodayUpcomingReleaseRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayUpcomingReleaseRecyclerview.adapter = HomeTodayUpcomingAdapter(upcomingGoodsList)
//
//        getOrcaAlternativesList()
//        binding.homeTodayOrcaAlternativesRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayOrcaAlternativesRecyclerview.adapter = HomeTodayGoodsAdapter(orcaAlternativesList, mainIntent)
//
//        getGreyCollectionsList()
//        binding.homeTodayGreyCollectionRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeTodayGreyCollectionRecyclerview.adapter = HomeTodayGoodsAdapter(greyCollectionsList, mainIntent)




    }

//
//
//
//    private fun getMostPopular() {
//        with(mostPopular) {
//            add(
//                GoodsList(
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList(
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList(
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getShoeKreamList() {
//        with(shoeKreamTagList) {
//            add(
//                StylePicksList(
//                    "${R.drawable.home_today_style_picks_style_sample}",
//                    "${R.drawable.home_today_style_picks_user_sample}",
//                    "@sin92"
//                )
//            )
//            add(
//                StylePicksList(
//                    "${R.drawable.home_today_style_picks_style_sample}",
//                    "${R.drawable.home_today_style_picks_user_sample}",
//                    "@sin92"
//                )
//            )
//            add(
//                StylePicksList(
//                    "${R.drawable.home_today_style_picks_style_sample}",
//                    "${R.drawable.home_today_style_picks_user_sample}",
//                    "@sin92"
//                )
//            )
//        }
//    }
//
//    private fun getKoreanCollectionList() {
//        with(koreanCollectionList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getXOffList() {
//        with(xOffWhiteList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getLegoList() {
//        with(legoList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getStreetwearList() {
//        with(streetwearsList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getSmallLeathersList() {
//        with(smallLeathersList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getContemporariesList() {
//        with(contemporariesList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getLuxurySneakersList() {
//        with(luxurySneakersList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getNewLowestAsksList() {
//        with(newLowestAsksList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getNewHighestBidsList() {
//        with(newHighestBidsList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getUpcomingGoodsList() {
//        with(upcomingGoodsList) {
//            add(
//                UpcomingGoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
//                )
//            )
//            add(
//                UpcomingGoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
//                )
//            )
//            add(
//                UpcomingGoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue"
//                )
//            )
//        }
//    }
//
//    private fun getOrcaAlternativesList() {
//        with(orcaAlternativesList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }
//
//    private fun getGreyCollectionsList() {
//        with(greyCollectionsList) {
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_image_sample1}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
//                    "1,249,000원"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//            add(
//                GoodsList
//                    (
//                    "${R.drawable.home_today_recycle_sample_img}",
//                    "${R.drawable.home_today_recycle_sample_logo}",
//                    "${R.string.home_today_recycle_item_goods_name_sample}",
//                    "${R.string.home_today_recycle_item_goods_price_sample}"
//                )
//            )
//        }
//    }



    override fun onGetHomeTodayInformationSuccess(response: ResponseHomeToday) {
        Log.d("1234", "${response.result}")

        val mainSlidersList: List<Mainslider> = response.result.mainslider
        val justDroppedListApi: List<JustDropped> = response.result.JustDropped
        val stylePicksListApi:List<Style> =response.result.Style

        binding.homeTodayAdPager.adapter = HomeTodayAdAdapter(mainSlidersList)
        binding.homeTodayAdPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


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

}