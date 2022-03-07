package com.jingom.simplelotto

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SimpleLottoApplication: Application() {

	override fun onCreate() {
		super.onCreate()

		init()
	}

	private fun init() {
		initTimber()
	}

	private fun initTimber() {
		Timber.plant(Timber.DebugTree())
	}
}