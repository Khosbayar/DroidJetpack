package hs.khosbayar.droidjetpack.data

import androidx.paging.DataSource

class EmployeeLocalCache(
    private val employeeDao: EmployeeDao
){

    suspend fun insert(employees: List<Employee>){
        employeeDao.insertAll(employees)
    }

    fun getEmployees(): DataSource.Factory<Int, Employee>{
        return employeeDao.getEmployees()
    }

}