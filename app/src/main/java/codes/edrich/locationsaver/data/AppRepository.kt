package codes.edrich.locationsaver.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import codes.edrich.locationsaver.data.local.LocationDatabase
import codes.edrich.locationsaver.data.remote.DummyAPI
import codes.edrich.locationsaver.model.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "APP_REPO"

class AppRepository(
    private val api: DummyAPI,
    private val database: LocationDatabase
) {
    private val _locations = MutableLiveData<List<Location>>()
    val locations: LiveData<List<Location>>
        get() = _locations

    suspend fun getStartUpLocations() {

        var startLocationList = listOf<Location>()

        withContext(Dispatchers.IO) {

            try {
                startLocationList = api.retrofitService.getLocations()
            } catch (e: Exception) {
                Log.e(TAG, "Failed loading data: ${e.localizedMessage}")
            }

            database.locationDatabaseDAO.insertAll(startLocationList)
            _locations.value = startLocationList
        }

    }
}