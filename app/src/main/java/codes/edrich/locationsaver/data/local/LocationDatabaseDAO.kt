package codes.edrich.locationsaver.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import codes.edrich.locationsaver.model.Location

interface LocationDatabaseDAO {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertAll(locations: List<Location>)

    @Query("SELECT * FROM Location")
    fun getAll(): LiveData<List<Location>>

    @Query("DELETE FROM Location")
    fun deleteAll()
}