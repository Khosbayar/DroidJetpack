package hs.khosbayar.droidjetpack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LuckyNumber::class, Employee::class], version = 1, exportSchema = false)
public abstract class DroidRoomDatabase : RoomDatabase(){

    abstract fun luckyNumberDao() : LuckyNumberDao
    abstract fun employeeDao() : EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: DroidRoomDatabase? = null

        fun getDatabase(context: Context): DroidRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DroidRoomDatabase::class.java,
                    "droid_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}
