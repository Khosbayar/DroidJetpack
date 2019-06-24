package hs.khosbayar.droidjetpack.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hs.khosbayar.droidjetpack.data.Employee
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

interface EmployeeApiService{

    @GET("employees")
    fun getEmployees(): Deferred<List<Employee>>

    @GET("employee/{id}")
    fun getEmployee(@Path("id") id: String): Employee


}

object EmployeeApi{
    val retrofitService: EmployeeApiService by lazy{
        retrofit.create(EmployeeApiService::class.java)
    }
}