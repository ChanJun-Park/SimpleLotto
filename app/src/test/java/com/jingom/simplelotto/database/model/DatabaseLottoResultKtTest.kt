package com.jingom.simplelotto.database.model

import com.jingom.simplelotto.screens.model.LottoResult
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DatabaseLottoResultKtTest {

	@Test
	fun toUiModel_hasSuccessResult_returnValidUiModel() {
		val uiModel = successDatabaseLottoResult.toUiModel()

		assertThat(uiModel, `is`(LottoResult(
			no1 = 1,
			no2 = 2,
			no3 = 3,
			no4 = 4,
			no5 = 5,
			no6 = 6,
			bonusNo = 24,
			lotteryNo = 861,
			day = "2019-06-01"
		)))
	}

	@Test
	fun toUiModel_hasFailResult_returnInvalidUiModel() {
		val uiModel = failDatabaseLottoResult.toUiModel()

		assertThat(uiModel, `is`(LottoResult(
			no1 = -1,
			no2 = -1,
			no3 = -1,
			no4 = -1,
			no5 = -1,
			no6 = -1,
			bonusNo = -1,
			lotteryNo = -1,
			day = ""
		)))
	}

	companion object {
		val successDatabaseLottoResult = DatabaseLottoResult(
			lotteryNo = 861,
			day = "2019-06-01",
			totalSellAmount = 81032551000,
			firstWinAmount = 4872108844,
			firstPrizeWinnerCount = 4,
			firstAccumulatedAmount = 19488435376,
			no1 = 1,
			no2 = 2,
			no3 = 3,
			no4 = 4,
			no5 = 5,
			no6 = 6,
			bonusNo = 24
		)

		val failDatabaseLottoResult = DatabaseLottoResult(
			lotteryNo = -1,
			day = "",
			totalSellAmount = -1,
			firstWinAmount = -1,
			firstPrizeWinnerCount = -1,
			firstAccumulatedAmount = -1,
			no1 = -1,
			no2 = -1,
			no3 = -1,
			no4 = -1,
			no5 = -1,
			no6 = -1,
			bonusNo = -1
		)
	}
}