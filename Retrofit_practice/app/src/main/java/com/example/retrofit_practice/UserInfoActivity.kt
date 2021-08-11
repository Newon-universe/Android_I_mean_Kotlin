package com.example.retrofit_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofit_practice.UserModule.GameName
import com.example.retrofit_practice.databinding.ActivityUserInfoBinding
import retrofit2.Call
import retrofit2.Response
import com.example.retrofit_practice.UserModule.UserTier

class UserInfoActivity : AppCompatActivity() {

    val api_key = "RGAPI-6c946c13-3cbe-4889-88b2-ddd86c28824f"
    var count = 20
    lateinit var lastGame:String
    lateinit var rankTier: String
    lateinit var turboTier: String

    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUserInfoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val userIntent = intent

        binding.userId.text = userIntent.getStringExtra("summonerName")
        val id = userIntent.getStringExtra("id")
        val globalId = userIntent.getStringExtra("globalId")
        getUserTier(id!!)
        getGameName(globalId!!, count)
    }

    fun getUserTier(Id: String) {
        val tierInterface = UserTierClient.sRetrofit.create(RiotInterface::class.java)

        tierInterface.getUserTier(Id, api_key).enqueue( object:
            retrofit2.Callback<UserTier> {
            override fun onResponse(call: Call<UserTier>, response: Response<UserTier>) {
                if (response.isSuccessful){
                    val result = response.body() as UserTier
                    rankTier = result[0].tier
                    turboTier = result[1].ratedTier
                    binding.rankTier.text = rankTier
                    binding.bustTier.text = turboTier
                }
            }

            override fun onFailure(call: Call<UserTier>, t: Throwable) {
                Log.d("TAG", "Something is wrong")
            }
        })

    }

    fun getGameName(globalId:String, count: Int){
        val gameNameInterface = GameNameClient.sRetrofit.equals(object : retrofit2.Callback<GameName>{
            override fun onResponse(call: Call<GameName>, response: Response<GameName>) {
                if(response.isSuccessful){
                    val result = response.body() as GameName
                    lastGame = result[0]
                }
            }

            override fun onFailure(call: Call<GameName>, t: Throwable) {
                Log.d("TAG", "Something is wrong")
            }

        })
    }














}