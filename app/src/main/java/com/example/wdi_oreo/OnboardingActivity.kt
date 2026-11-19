package com.example.wdi_oreo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wdi_oreo.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(
            Onboard1Fragment(),
            Onboard2Fragment(),
            Onboard3Fragment()
        )

        val adapter = OnboardingAdapter(this, fragments)
        binding.viewPagerOnboarding.adapter = adapter
        binding.dotIndicator.attachTo(binding.viewPagerOnboarding)

        // Tombol panah kiri & teks "Kembali ke Home"
        binding.btnBackOnboarding.setOnClickListener {
            finish()
        }
    }
}