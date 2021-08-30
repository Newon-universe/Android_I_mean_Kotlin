package com.softsquared.template.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.home.home_main.HomeMainFragment
import com.softsquared.template.kotlin.src.main.my.MyMainFragment
import com.softsquared.template.kotlin.src.main.shop.ShopFragment
import com.softsquared.template.kotlin.src.main.style.StyleFragment
import com.softsquared.template.kotlin.src.main.watch.WatchFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var jwtToken:String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeMainFragment()).commitAllowingStateLoss()
        jwtChecking()
        binding.mainBtmNav.itemIconTintList = null

    }

    override fun onResume() {
        super.onResume()
        jwtChecking()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeMainFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_style -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, StyleFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_shop -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ShopFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_watch -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, WatchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my_page -> {
                        if(jwtToken == ""){
                            val intent = Intent(this, LoginActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                        }
                        else {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyMainFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                }
                false
            })
    }

    fun jwtChecking(){
        jwtToken = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "")
        Log.d("why", "JWT CHECKER")
        Log.d("why", "$jwtToken")
    }


}