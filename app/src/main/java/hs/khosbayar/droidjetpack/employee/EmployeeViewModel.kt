package hs.khosbayar.droidjetpack.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hs.khosbayar.droidjetpack.network.Employee
import hs.khosbayar.droidjetpack.network.EmployeeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel: ViewModel(){

    private val _employees = MutableLiveData<List<Employee>>()
    val employees : LiveData<List<Employee>>
        get() = _employees

    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
        get() = _status


    private val viewModelJob = Job()

    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{
        _status.value = Status.LOADING
        getEmployees()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getEmployees() = viewModelScope.launch {
        val employeesDeferred = EmployeeApi.retrofitService.getEmployees()
        try{
            _status.value = Status.LOADING
            val list = employeesDeferred.await()
            _employees.value = list
            _status.value = Status.DONE
        }catch (e: Exception){
            _status.value = Status.ERROR
            _employees.value = ArrayList()
        }
    }
}

enum class Status { DONE, LOADING, ERROR }