package com.jingom.simplelotto.dependnecyinjection.app

import com.jingom.simplelotto.network.DHLottoApi
import com.jingom.simplelotto.network.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @AppScope
    fun retrofit(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
                .baseUrl(urlProvider.getDHLottoBaseUrl())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun dhLottoApi(retrofit: Retrofit) = retrofit.create(DHLottoApi::class.java)

}