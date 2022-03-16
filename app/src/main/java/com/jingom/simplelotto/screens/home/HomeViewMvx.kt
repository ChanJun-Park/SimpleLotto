package com.jingom.simplelotto.screens.home

import com.jingom.simplelotto.screens.model.LottoResult
import com.jingom.simplelotto.screens.views.ViewMvx

interface HomeViewMvx: ViewMvx {
	fun bindLottoResult(lottoResult: LottoResult)
}