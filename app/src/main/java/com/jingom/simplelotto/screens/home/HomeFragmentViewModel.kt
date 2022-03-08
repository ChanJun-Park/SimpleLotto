package com.jingom.simplelotto.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jingom.simplelotto.screens.model.LottoResult
import com.jingom.simplelotto.usecase.LatestLottoResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
	private val latestLottoResultUseCase: LatestLottoResultUseCase
): ViewModel() {

	private val _latestLottoResult = MutableLiveData<LottoResult>()
	val latestLottoResult: LiveData<LottoResult> get() = _latestLottoResult

	init {
		viewModelScope.launch {
			_latestLottoResult.value = latestLottoResultUseCase.getLatestLottoResult()
		}
	}
}