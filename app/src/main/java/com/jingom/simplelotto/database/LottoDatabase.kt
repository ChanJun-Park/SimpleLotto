package com.jingom.simplelotto.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jingom.simplelotto.database.dao.LottoResultDao
import com.jingom.simplelotto.database.model.DatabaseLottoResult

@Database(entities = [DatabaseLottoResult::class], version = 1, exportSchema = false)
abstract class LottoDatabase : RoomDatabase() {

	abstract val lottoResultDao: LottoResultDao
}