package hs.khosbayar.droidjetpack.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import hs.khosbayar.droidjetpack.data.Employee
import hs.khosbayar.droidjetpack.data.EmployeeRepository
import hs.khosbayar.droidjetpack.data.LuckyNumberRepository
import hs.khosbayar.droidjetpack.network.EmployeeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel(private val repository: EmployeeRepository): ViewModel(){

//    private val _employees = MutableLiveData<PagedList<Employee>>()
    val employees : LiveData<PagedList<Employee>>
        get() = repository.getEmployees().data

    val networkError: LiveData<String>
        get() = repository.getEmployees().networkError

    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
        get() = _status


//    private val viewModelJob = Job()

//    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{
        _status.value = Status.LOADING
        getEmployees()
    }

//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

    fun getEmployees() {

//        val employeesDeferred = EmployeeApi.retrofitService.getEmployees()
//        try{
//            _status.value = Status.LOADING
//            val list = employeesDeferred.await()
//            _employees.value = list
//            _status.value = Status.DONE
//        }catch (e: Exception){
//            _status.value = Status.ERROR
//            _employees.value = ArrayList()
//        }

//        val result = repository.getEmployees()
////        _employees = result.data
    }
}

enum class Status { DONE, LOADING, ERROR }