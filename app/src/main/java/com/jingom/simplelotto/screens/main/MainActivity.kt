package com.jingom.simplelotto.screens.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.jingom.simplelotto.databinding.ActivityMainBinding
import com.jingom.simplelotto.support.doOnApplyWindowInsets
import com.jingom.simplelotto.support.isRtl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		initSystemUIColor()

		initWindowEdgeToEdgeConfig()
	}

	private fun initSystemUIColor() {
		WindowInsetsControllerCompat(window, binding.root).apply {
			isAppearanceLightStatusBars = true
			isAppearanceLightNavigationBars = true
		}
	}

	private fun initWindowEdgeToEdgeConfig() {
		WindowCompat.setDecorFitsSystemWindows(window, false)
	}
}