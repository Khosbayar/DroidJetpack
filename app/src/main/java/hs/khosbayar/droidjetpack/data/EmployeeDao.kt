package hs.khosbayar.droidjetpack.data

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employees: List<Employee>)

    @Query("SELECT * FROM employee")
    fun getEmployees(): DataSource.Factory<Int, Employee>
}