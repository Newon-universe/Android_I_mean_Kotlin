package com.example.kakaologinpractice

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kakaologinpractice.databinding.ActivityKakaoLoginBinding
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.Profile
import com.kakao.sdk.user.model.User

class KakaoLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKakaoLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKakaoLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kakao_logout_button = binding.kakaoLogoutButton // 로그인 버튼

        kakao_logout_button.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        val kakao_unlink_button = binding.kakaoUnlinkButton // 로그인 버튼

        kakao_unlink_button.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Toast.makeText(this, "회원 탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "회원 탈퇴 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        var name: String?
        var profile: String?
        var email: String?
        var birthday: String?
        var nation: Boolean?

        UserApiClient.instance.me { user, error ->
            name = user?.kakaoAccount?.profile?.nickname
            email = user?.kakaoAccount?.email
            profile = user?.kakaoAccount?.profile?.profileImageUrl
            birthday = user?.kakaoAccount?.birthday
            nation = user?.kakaoAccount?.isKorean
            Log.d("kakao", "$name, $email\n${profile}")
            binding.nickname.text = name
            binding.email.text = email
            Glide.with(this).load(profile).into(binding.profile)
            if( birthday != null)
                binding.birthday.text = birthday
            if (nation == true)
                binding.birthday.text = "한국 유저"
        }

    }
}
