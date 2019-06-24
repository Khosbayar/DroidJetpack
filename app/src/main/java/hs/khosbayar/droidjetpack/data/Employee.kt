package hs.khosbayar.droidjetpack.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "employee")
@Parcelize
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @Json(name ="employee_name")
    @ColumnInfo(name ="employee_name")
    var name: String = "",

    @Json(name ="employee_salary")
    @ColumnInfo(name ="employee_salary")
    var salary: String = "",

    @Json(name ="employee_age")
    @ColumnInfo(name ="employee_age")
    var age: String = "",

    @Json(name ="profile_image")
    @ColumnInfo(name ="profile_image")
    var img: String = ""
) : Parcelable