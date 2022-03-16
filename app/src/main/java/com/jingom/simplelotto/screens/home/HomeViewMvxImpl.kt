package com.jingom.simplelotto.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.jingom.simplelotto.R
import com.jingom.simplelotto.databinding.HomeLayoutBinding
import com.jingom.simplelotto.screens.home.adapter.LatestLottoResultAdapter
import com.jingom.simplelotto.screens.model.LottoResult
import com.jingom.simplelotto.screens.views.BaseViewMvx

class HomeViewMvxImpl(
	lifecycleOwner: LifecycleOwner,
	layoutInflater: LayoutInflater,
	parent: ViewGroup?
): BaseViewMvx(lifecycleOwner, layoutInflater, parent, R.layout.home_layout), HomeViewMvx {

	private val binding: HomeLayoutBinding by dataBindings(HomeLayoutBinding::bind)
	private val adapter = LatestLottoResultAdapter()

	init {
		binding.homeUiList.adapter = adapter
	}

	override fun bindLottoResult(lottoResult: LottoResult) {
		adapter.lottoResult = lottoResult
	}
}