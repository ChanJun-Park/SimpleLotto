package com.jingom.simplelotto.screens.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.jingom.simplelotto.screens.home.HomeViewMvx
import com.jingom.simplelotto.screens.home.HomeViewMvxImpl
import javax.inject.Inject

class ViewMvxFactory @Inject constructor(
	private val layoutInflater: LayoutInflater
) {
	fun getHomeViewMvx(lifecycleOwner: LifecycleOwner, parent: ViewGroup?): HomeViewMvx {
		return HomeViewMvxImpl(lifecycleOwner, layoutInflater, parent)
	}
}