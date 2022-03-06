package com.jingom.simplelotto.screens.model

import com.jingom.simplelotto.database.model.INVALID

data class LottoResult(
	val no1: Int = INVALID,
	val no2: Int = INVALID,
	val no3: Int = INVALID,
	val no4: Int = INVALID,
	val no5: Int = INVALID,
	val no6: Int = INVALID,
	val bonusNo: Int = INVALID,
	val lotteryNo: Int = INVALID,
	val day: String = ""
)