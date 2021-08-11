package com.example.retrofit_practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_practice.UserModule.UserInfo
import com.example.retrofit_practice.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val api_key = "RGAPI-6c946c13-3cbe-4889-88b2-ddd86c28824f"
    var id: String = "먼데"
    var name: String = "먼데"
    var globalId: String = "먼데"
    var check: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener(){
            getUserData(binding.searchName.text.toString(), api_key)
            if(!check){
                binding.summonerName.text = "그런 사람 없습니다"
                binding.searchName.visibility = View.VISIBLE
            }
        }
    }


//    1. Data Class 정의하기
//    2. API 호출을 위한 인터페이스 정의하기
//    3. Retrofit client 생성하기
//    4. Request 전송하기

    fun getUserData(summonerName: String, key: String) {
        val userInterface = LoginClient.sRetrofit.create(RiotInterface::class.java)
        userInterface.getUser(summonerName, api_key).enqueue(object : Callback<UserInfo> {
            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if (response.isSuccessful) {
                    val result = response.body() as UserInfo
                    name = result.name
                    id = result.id
                    globalId = result.puuid
                    val intent = Intent(this@LoginActivity, UserInfoActivity::class.java)
                    with(intent){
                        putExtra("summonerName", name)
                        putExtra("id",id)
                        putExtra("globalId", globalId)
                    }
                    startActivity(intent)
                } else {
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

// 소셜로그인 구현 및 성공 시 정보 가져오기 (이미지 받아서 띄우기 - glide)
// 필수항목 받지 않고 갔을 때 어떻게 핸들링 할 것인가? -> 비동의했을 때, 동의가 필요한 부분이 생기면 어떻게 처리할 것인가
