package codes.edrich.locationsaver.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class LocationDatabase : RoomDatabase() {

    abstract val locationDatabaseDAO: LocationDatabaseDAO
}

private lateinit var INSTANCE: LocationDatabase

fun getDatabase(context: Context): LocationDatabase {
    synchronized(LocationDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                LocationDatabase::class.java,
                "location_database"
            )
                .build()
        }
    }
    return INSTANCE
}