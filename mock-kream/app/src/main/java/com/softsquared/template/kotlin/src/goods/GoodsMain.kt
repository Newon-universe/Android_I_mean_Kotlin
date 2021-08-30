package com.softsquared.template.kotlin.src.goods

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityGoodsMainBinding
import com.softsquared.template.kotlin.src.goods.before_sell.GoodsBeforeSellFragment
import com.softsquared.template.kotlin.src.goods.befroe_buy.GoodsBeforeBuyFragment
import com.softsquared.template.kotlin.src.goods.goods_like_bottomsheet.GoodsLikeBottomSheetFragment
import com.softsquared.template.kotlin.src.goods.models.ResponseGoods
import com.softsquared.template.kotlin.src.goods.models_immediately_buy.ResponseImmediatelyBuy
import com.softsquared.template.kotlin.src.goods.models_immediately_sell.ResponseImmediatelySell
import kotlin.properties.Delegates

data class RelatedGoodsList(val image: String, val brand: String, val title:String, val price:String, val idx:String)

class GoodsMain : BaseActivity<ActivityGoodsMainBinding>(ActivityGoodsMainBinding::inflate), GoodsMainView {

    private var relatedGoodsList:MutableList<RelatedGoodsList> = mutableListOf()
    var shouldBuyBottomSheetOpen:String = "Yes"
    var shouldSellBottomSheetOpen:String = "Yes"


    // idx == goodsIdx
    var goodsIdx = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val idx = intent.getIntExtra("idx", -1)
        goodsIdx = idx

        GoodsMainService(this).tryGetGoodsMain(idx)
        GoodsMainService(this).tryGetImmediatelyBuy(idx)
        GoodsMainService(this).tryGetImmediatelySell(idx)

        setSupportActionBar(binding.goodsMainTopToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onResume() {
        super.onResume()

        binding.goodsMainBtmBarBtnBuy.setOnClickListener{
            if(shouldBuyBottomSheetOpen == "No"){
                val bottomSheet = GoodsBottomSheetFragment({
                    binding.goodsMainSizeBtn.text = it[0]
                    binding.goodsMainRecentBidPrice.text = it[1]
                    binding.goodsMainBtmBarTvBuyPrice.text = it[1]
                })
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                shouldBuyBottomSheetOpen = "Yes"
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.goods_before_frame_layout, GoodsBeforeBuyFragment())
                    .commitAllowingStateLoss()
            }
        }

        binding.goodsMainSizeBtn.setOnClickListener {
            val bottomSheet = GoodsBottomSheetFragment({
                binding.goodsMainSizeBtn.text = it[0]
                binding.goodsMainRecentBidPrice.text = it[1]
                binding.goodsMainBtmBarTvBuyPrice.text = it[1]
                binding.goodsMainBtmBarTvSellPrice.text = it[1]
            })
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            if(binding.goodsMainRecentBidPrice.text == "-" || binding.goodsMainRecentBidPrice.text == "210000"){
                shouldBuyBottomSheetOpen = "Yes"
                shouldSellBottomSheetOpen = "Yes"
            }
            else{
                shouldBuyBottomSheetOpen = "No"
                shouldSellBottomSheetOpen = "No"
            }
        }

        binding.goodsMainBtmBarBtnSell.setOnClickListener {
            if(shouldSellBottomSheetOpen == "No"){
                val bottomSheet = GoodsBottomSheetFragment({
                    binding.goodsMainSizeBtn.text = it[0]
                    binding.goodsMainRecentBidPrice.text = it[1]
                    binding.goodsMainBtmBarTvSellPrice.text = it[1]
                })
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                shouldSellBottomSheetOpen = "Yes"
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.goods_before_frame_layout, GoodsBeforeSellFragment())
                    .commitAllowingStateLoss()
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                finish()
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }



    private fun getGoodsMainInformationList(): ArrayList<Int> {
        return arrayListOf<Int>(
            R.string.goods_main_information_model_sample,
            R.string.goods_main_information_released_date_sample,
            R.string.goods_main_information_primary_color_sample,
            R.string.goods_main_information_released_price_sample
        )
    }

    override fun onGetGoodsMainSuccess(response: ResponseGoods) {

        showCustomToast(response.message)

        val info = response.result.info
        binding.goodsMainBrand.text = info[0].brand
        binding.goodsMainName.text = info[0].name
        binding.goodsMainNameKr.text = info[0].nameHan


        if(response.isSuccess){
            val imageList = response.result.imagelist
            binding.goodsMainTopCollapsingGoodsViewpager.adapter = GoodsMainCollapsingAdapter(imageList)


            val goodsinfo = response.result.goods_info
            binding.goodsMainInformationRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.goodsMainInformationRecyclerview.adapter = GoodsMainInformationAdapter(goodsinfo)


            getRelatedGoodsList()
            binding.goodsMainRelatedItemsRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.goodsMainRelatedItemsRecyclerview.adapter = GoodsMainRelatedListAdapter(relatedGoodsList,
                ({
                    this.finish()
                    val intent: Intent = Intent(this, GoodsMain::class.java).apply {
                        putExtra("idx", it)
                    }
                    startActivity(intent)
                }))


            binding.goodsMainBtmBarIcBookmark.setOnClickListener {
                val bottomSheet = GoodsLikeBottomSheetFragment(goodsIdx)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }
        }

    }


    private fun getRelatedGoodsList() {
        with(relatedGoodsList) {
            add(
                RelatedGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "Jordan 1 x Travis Scott x Fragment Retro Low OG SP Military Blue",
                    "1,249,000원",
                    "1"
                )
            )
            add(
                RelatedGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}",
                    "1"
                )
            )
            add(
                RelatedGoodsList
                    (
                    "${R.drawable.home_today_recycle_sample_img}",
                    "${R.drawable.home_today_recycle_sample_logo}",
                    "${R.string.home_today_recycle_item_goods_name_sample}",
                    "${R.string.home_today_recycle_item_goods_price_sample}",
                    "1"
                )
            )
        }
    }


    override fun onGetGoodsMainFailure(message: String) {
        showCustomToast(message)
    }

    override fun onGetImmediatelyBuySuccess(response: ResponseImmediatelyBuy) {
        binding.goodsMainSizeBtn.text = response.result[0].size.toString()
        binding.goodsMainBtmBarTvBuyPrice.text = response.result[0].price.toString()
        shouldBuyBottomSheetOpen= "No"
    }

    override fun onGetImmediatelyBuyFailure(message: String) {
        showCustomToast(message)
    }

    override fun onGetImmediatelySellSuccess(response: ResponseImmediatelySell) {
        binding.goodsMainBtmBarTvSellPrice.text = response.result[0].price.toString()
        shouldSellBottomSheetOpen = "No"
    }

    override fun onGetImmediatelySellFailure(message: String) {
        showCustomToast(message)
    }

}