package hs.khosbayar.droidjetpack.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmployeeViewModelProviderFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmployeeViewModel::class.java)){
            return EmployeeViewModel() as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}