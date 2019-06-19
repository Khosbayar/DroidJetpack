package hs.khosbayar.droidjetpack.second

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import hs.khosbayar.droidjetpack.data.DroidRoomDatabase
import hs.khosbayar.droidjetpack.data.LuckyNumber
import hs.khosbayar.droidjetpack.data.LuckyNumberDao
import hs.khosbayar.droidjetpack.data.LuckyNumberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SecondViewModel(app: Application,val chosenNumber: Int) : AndroidViewModel(app){

    private val numberDao: LuckyNumberDao = DroidRoomDatabase.getDatabase(app).luckyNumberDao()
    private val repo : LuckyNumberRepository
    val allNumbers : LiveData<List<LuckyNumber>>

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        repo = LuckyNumberRepository(numberDao)
        allNumbers = repo.allNumbers
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun insert(number : LuckyNumber) = viewModelScope.launch { repo.insert(number) }

    fun incrementNumber(number: LuckyNumber) = viewModelScope.launch {
        number.number++
        repo.update(number)
    }

    fun onClickDeleteAll() = viewModelScope.launch {
        repo.deleteAll()
    }

}