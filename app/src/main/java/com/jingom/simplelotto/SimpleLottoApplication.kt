package com.jingom.simplelotto

import android.app.Application
import timber.log.Timber

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