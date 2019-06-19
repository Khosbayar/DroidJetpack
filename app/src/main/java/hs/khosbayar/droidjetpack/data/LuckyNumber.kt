package hs.khosbayar.droidjetpack.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "lucky_number")
@Parcelize
data class LuckyNumber(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "number")
    var number: Int = 0
): Parcelable