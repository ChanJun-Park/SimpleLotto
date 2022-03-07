package com.jingom.simplelotto.screens.main

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.jingom.simplelotto.screens.model.LottoResult

@BindingAdapter("lottoResult")
fun TextView.setLottoResult(lottoResult: LottoResult?) {
	if (lottoResult == null) {
		return
	}
	text = "no1 : ${lottoResult.no1}, no2 : ${lottoResult.no2}, no3 : ${lottoResult.no3}, no4 : ${lottoResult.no4}, no5 : ${lottoResult.no5}, no6 : ${lottoResult.no6}"
}