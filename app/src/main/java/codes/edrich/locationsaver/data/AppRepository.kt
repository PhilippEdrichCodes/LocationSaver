package codes.edrich.locationsaver.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import codes.edrich.locationsaver.data.remote.DummyAPI
import codes.edrich.locationsaver.model.Location

private const val TAG = "APP_REPO"

class AppRepository(
    private val api: DummyAPI
    // val database: Database
)
{
    private val _locations = MutableLiveData<List<Location>>()
    val locations: LiveData<List<Location>>
    get() = _locations

    suspend fun getStartUpLocations() {
        try {
            _locations.value = api.retrofitService.getLocation()
        } catch (e: Exception) {
            Log.e(TAG, "Failed loading data: ${e.localizedMessage}")
        }
    }

    // ToDo
}