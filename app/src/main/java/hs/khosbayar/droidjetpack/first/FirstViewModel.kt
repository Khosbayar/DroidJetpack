package hs.khosbayar.droidjetpack.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class FirstViewModel(text: String) : ViewModel(){

    private val _text = MutableLiveData<String>()
    val text : LiveData<String>
        get() = _text

    private var rand = Random()

    private val _navigateToSecond = MutableLiveData<Boolean>()
    val navigateToSecond : LiveData<Boolean>
        get() = _navigateToSecond

    private val _navigateToEmployees = MutableLiveData<Boolean>()
    val navigateToEmployees : LiveData<Boolean>
        get() = _navigateToEmployees

    init {
        _text.value = text
        _navigateToSecond.value = false
        _navigateToEmployees.value = false
    }

    fun onClickGetRandom(){
        val randomNum = rand.nextInt(100)
        _text.value = randomNum.toString()
    }

    fun onClickNavigateToSecond(){
        _navigateToSecond.value = true
    }

    fun doneNavigatingToSecond(){
        _navigateToSecond.value = false
    }

    fun onClickNavigateEmployees(){
        _navigateToEmployees.value = true
    }

    fun doneNavigatingToEmployees(){
        _navigateToEmployees.value = false
    }

}