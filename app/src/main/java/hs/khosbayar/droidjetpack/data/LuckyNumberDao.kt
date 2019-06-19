package hs.khosbayar.droidjetpack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LuckyNumberDao{

    @Query("SELECT * FROM lucky_number ORDER BY id ASC")
    fun getAllLuckyNumbers() : LiveData<List<LuckyNumber>>

    @Insert
    suspend fun insertLuckyNumber(number: LuckyNumber)

    @Update
    suspend fun updateLuckyNumber(number: LuckyNumber)

    @Query("DELETE FROM lucky_number")
    suspend fun deleteAll()

}