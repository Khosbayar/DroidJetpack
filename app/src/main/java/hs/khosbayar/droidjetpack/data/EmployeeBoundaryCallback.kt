package hs.khosbayar.droidjetpack.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import hs.khosbayar.droidjetpack.network.EmployeeApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeBoundaryCallback(
    private val service: EmployeeApiService,
    private val cache: EmployeeLocalCache
):PagedList.BoundaryCallback<Employee>(){

    private var isRequestInProgress = false

    private val _networkErrors = MutableLiveData<String>()

    // LiveData of network errors.
    val networkErrors : LiveData<String>
        get() = _networkErrors

    override fun onZeroItemsLoaded() {
        requestSaveData()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Employee) {
        requestSaveData()
    }

    private fun requestSaveData(){
        if(isRequestInProgress)
            return

        isRequestInProgress = true
        GlobalScope.launch {

            val empsDeferred = service.getEmployees()
            try{
                val emps = empsDeferred.await()
                cache.insert(emps)
            }catch (e: Exception){
//                _networkErrors.value = e.message
            }finally {
                isRequestInProgress = false
            }
        }
    }
}