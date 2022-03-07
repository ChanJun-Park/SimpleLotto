package com.jingom.simplelotto.usecase

import com.jingom.simplelotto.database.LottoResultRepository
import com.jingom.simplelotto.database.model.toUiModel
import com.jingom.simplelotto.screens.model.LottoResult
import javax.inject.Inject

class LatestLottoResultUseCase @Inject constructor(
	private val lottoResultRepository: LottoResultRepository
) {
	suspend fun getLatestLottoResult(): LottoResult = lottoResultRepository.getLatestLottoResult().toUiModel()
}