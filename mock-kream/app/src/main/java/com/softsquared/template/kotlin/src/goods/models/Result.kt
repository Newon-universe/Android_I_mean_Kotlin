package com.softsquared.template.kotlin.src.goods.models

data class Result(
    val goods_info: List<GoodsInfo>,
    val imagelist: List<String>,
    val info: List<Info>,
    val size_price: List<SizePrice>
)