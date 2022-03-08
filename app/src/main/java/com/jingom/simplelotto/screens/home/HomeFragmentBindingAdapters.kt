package com.jingom.simplelotto.screens.home

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jingom.simplelotto.R
import com.jingom.simplelotto.screens.model.LottoResult

@BindingAdapter("lottoRoundNumber")
fun TextView.setLottoRoundNumber(lottoRoundNumber: Int?) {
	if (lottoRoundNumber == null) {
		return
	}
	text = resources.getString(R.string.round, lottoRoundNumber)
}

@BindingAdapter("dayOfLottery")
fun TextView.setDayOfLottery(dayOfLottery: String?) {
	if (dayOfLottery == null) {
		return
	}
	text = dayOfLottery
}