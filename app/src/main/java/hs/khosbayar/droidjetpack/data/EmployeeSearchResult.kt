package hs.khosbayar.droidjetpack.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class EmployeeSearchResult(
    val data: LiveData<PagedList<Employee>>,
    val networkError: LiveData<String>)