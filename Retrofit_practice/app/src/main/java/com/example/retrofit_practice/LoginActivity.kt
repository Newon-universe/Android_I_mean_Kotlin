package com.example.retrofit_practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_practice.UserModule.UserInfo
import com.example.retrofit_practice.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val api_key = "RGAPI-d411eae1-d0c6-4322-bf2b-d5f7d88f6cd9"
    lateinit var puuid: String
    lateinit var name: String
    var check: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener(){
            getUserData(binding.searchName.text.toString(), api_key)
//            if(check){
//                val intent = Intent(this, UserInfoActivity::class.java)
//                intent.putExtra("summonerName", name)
//                intent.putExtra("puuid", puuid)
//
//                startActivity(intent)
//            }
        }

    }

//    1. Data Class 정의하기
//    2. API 호출을 위한 인터페이스 정의하기
//    3. Retrofit client 생성하기
//    4. Request 전송하기

    private fun getUserData(summonerName: String, key: String) {
        val userInterface = LoginClient.sRetrofit.create(RiotInterface::class.java)
        userInterface.getUser(summonerName, api_key).enqueue(object : Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if (response.isSuccessful) {
                    val result = response.body() as UserInfo
                    name = result.name
                    puuid = result.puuid
                } else {
                    binding.summonerName.text = "그런 사람은 없습니다"
                    check = false
                }
            }

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Log.d("allis", "MainActivity - () called")
                check = false
            }


        })
    }


}