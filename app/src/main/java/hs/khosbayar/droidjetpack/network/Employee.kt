package hs.khosbayar.droidjetpack.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Employee(
    var id: Long = 0L,
    @Json(name ="employee_name")
    var name: String = "",
    @Json(name ="employee_salary")
    var salary: String = "",
    @Json(name ="employee_age")
    var age: String = "",
    @Json(name ="profile_image")
    private var img: String = ""
) : Parcelable