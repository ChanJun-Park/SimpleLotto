package com.jingom.simplelotto.network

import com.jingom.simplelotto.network.model.NetworkLottoResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DHLottoApi {
	@GET("common.do")
	suspend fun getLottoNumber(@Query("method") method: String, @Query("drwNo") drwNo: Int): Response<NetworkLottoResult>
}