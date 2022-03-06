package com.jingom.simplelotto.dependnecyinjection.app

import android.app.Application
import androidx.room.Room
import com.jingom.simplelotto.database.LottoDatabase
import com.jingom.simplelotto.network.DHLottoApi
import com.jingom.simplelotto.network.UrlProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    fun moshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @AppScope
    fun retrofit(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getDHLottoBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .build()
    }

    @Provides
    @AppScope
    fun urlProvider() = UrlProvider()

    @Provides
    @AppScope
    fun dhLottoApi(retrofit: Retrofit): DHLottoApi = retrofit.create(DHLottoApi::class.java)

	@Provides
	@AppScope
	fun lottoDatabase(application: Application): LottoDatabase {
		return Room.databaseBuilder(
			application,
			LottoDatabase::class.java,
			"lotto_database"
		)
			.fallbackToDestructiveMigration()
			.build()
	}
}