package com.jingom.simplelotto.network.model

import com.jingom.simplelotto.database.model.DatabaseLottoResult
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

class NetworkLottoResultKtTest {

	@Test
	fun isSuccess_hasSuccessResult_returnTrue() {
		assertThat(successNetworkLottoResult.isSuccess(), `is`(true))
	}

	@Test
	fun isSuccess_hasFailResult_returnTrue() {
		assertThat(failNetworkLottoResult.isSuccess(), `is`(false))
	}

	@Test
	fun isFail_hasSuccessResult_returnFalse() {
		assertThat(successNetworkLottoResult.isFail(), `is`(false))
	}

	@Test
	fun isFail_hasFailResult_returnTrue() {
		assertThat(failNetworkLottoResult.isFail(), `is`(true))
	}

	@Test
	fun toDatabaseModel_hasValidData_returnValidDatabaseModel() {
		val databaseModel = successNetworkLottoResult.toDatabaseModel()

		assertThat(databaseModel, `is`(DatabaseLottoResult(
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
		)))
	}

	@Test
	fun toDatabaseModel_hasInvalidData_returnInvalidDatabaseModel() {
		val databaseModel = failNetworkLottoResult.toDatabaseModel()

		assertThat(databaseModel, `is`(DatabaseLottoResult(
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
		)))
	}

	companion object {
		val successNetworkLottoResult = NetworkLottoResult(
			apiResult = "success",
			dayOfLottery = "2019-06-01",
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
			bonusNo = 24,
			lotteryNo = 861
		)

		val failNetworkLottoResult = NetworkLottoResult(
			apiResult = "fail",
			dayOfLottery = null,
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
			bonusNo = -1,
			lotteryNo = -1
		)
	}
}