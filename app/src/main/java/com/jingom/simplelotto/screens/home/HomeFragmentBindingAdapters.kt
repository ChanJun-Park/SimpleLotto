package com.jingom.simplelotto.screens.home

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jingom.simplelotto.R
import com.jingom.simplelotto.ui.LottoBall

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

@BindingAdapter("lottoNumber")
fun LottoBall.setLottoNumber(lottoNumber: Int?) {
	if (lottoNumber == null) {
		return
	}

	this.lottoNumber = lottoNumber
}

@BindingAdapter("setBonus")
fun LottoBall.setBonus(bonus: Boolean?) {
	if (bonus == null) {
		return
	}

	this.isBonus = bonus
}