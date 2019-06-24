package hs.khosbayar.droidjetpack.data

import androidx.paging.LivePagedListBuilder
import hs.khosbayar.droidjetpack.network.EmployeeApiService

class EmployeeRepository(
    private val service: EmployeeApiService,
    private val cache: EmployeeLocalCache
){

    fun getEmployees(): EmployeeSearchResult{
        val dataSourceFactory = cache.getEmployees()

        val boundaryCallback = EmployeeBoundaryCallback(service, cache)
        val networkError = boundaryCallback.networkErrors

        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        return EmployeeSearchResult(data, networkError)


    }

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}