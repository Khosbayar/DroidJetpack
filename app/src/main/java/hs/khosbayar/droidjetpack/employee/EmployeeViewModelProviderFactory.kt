package hs.khosbayar.droidjetpack.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hs.khosbayar.droidjetpack.data.EmployeeRepository

class EmployeeViewModelProviderFactory(private val repository: EmployeeRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmployeeViewModel::class.java)){
            return EmployeeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}