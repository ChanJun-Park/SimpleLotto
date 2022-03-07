package com.jingom.simplelotto.database

import com.jingom.simplelotto.database.dao.LottoResultDao
import com.jingom.simplelotto.database.model.DatabaseLottoResult
import com.jingom.simplelotto.network.DHLottoApi
import com.jingom.simplelotto.network.model.NetworkLottoResult
import com.jingom.simplelotto.network.model.isFail
import com.jingom.simplelotto.network.model.toDatabaseModel
import com.jingom.simplelotto.support.LottoUtils
import java.lang.IllegalStateException
import javax.inject.Inject

class LottoResultRepository @Inject constructor(
	private val lottoApi: DHLottoApi,
	private val lottoResultDao: LottoResultDao
) {
	suspend fun getLatestLottoResult(): DatabaseLottoResult {
		val calculatedLatestLottoNo = LottoUtils.getLatestLottoNo()
		val latestLottoResultInDB = lottoResultDao.getLatestLottoResult()

		if (latestLottoResultInDB != null && latestLottoResultInDB.lotteryNo == calculatedLatestLottoNo) {
			return latestLottoResultInDB
		}

		val lottoResponseBody = fetchLatestLottoResultFromServer(calculatedLatestLottoNo)

		lottoResultDao.insert(lottoResponseBody.toDatabaseModel())
		return lottoResultDao.getLatestLottoResult() ?: throw IllegalStateException("최신 로또번호를 불러오는데 실패했습니다.")
	}

	private suspend fun fetchLatestLottoResultFromServer(calculatedLatestLottoNo: Int): NetworkLottoResult {
		var latestLottoNo = calculatedLatestLottoNo

		var lottoResponseBody = lottoApi.fetchLottoNumber("getLottoNumber", latestLottoNo).body()

		while (lottoResponseBody == null || lottoResponseBody.isFail()) {
			if (latestLottoNo <= 0) {
				throw IllegalStateException("최신 로또번호를 불러오는데 실패했습니다.")
			}

			latestLottoNo--

			lottoResponseBody = lottoApi.fetchLottoNumber("getLottoNumber", latestLottoNo).body()
		}
		return lottoResponseBody
	}
}