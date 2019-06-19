package hs.khosbayar.droidjetpack.data

import androidx.lifecycle.LiveData

class LuckyNumberRepository(private val luckyNumberDao: LuckyNumberDao){

    val allNumbers: LiveData<List<LuckyNumber>> = luckyNumberDao.getAllLuckyNumbers()

    suspend fun insert(number: LuckyNumber){
        luckyNumberDao.insertLuckyNumber(number)
    }

    suspend fun update(number: LuckyNumber){
        luckyNumberDao.updateLuckyNumber(number)
    }

    suspend fun deleteAll(){
        luckyNumberDao.deleteAll()
    }
}