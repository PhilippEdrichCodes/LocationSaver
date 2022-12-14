package codes.edrich.locationsaver.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import codes.edrich.locationsaver.data.AppRepository
import codes.edrich.locationsaver.data.local.getDatabase
import codes.edrich.locationsaver.data.remote.DummyAPI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

const val TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = AppRepository(DummyAPI, database)

    private val firebaseAuth = FirebaseAuth.getInstance()

    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    // var locations = repository.locations

    // init { getData() }

    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                login(email, password)
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception?.localizedMessage}")
            }
        }
    }

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
            } else {
                Log.e(TAG, "Login failed: ${it.exception?.localizedMessage}")
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }

    // private fun getData() {
    //    viewModelScope.launch {
    //        try {
    //            repository.getStartUpLocations()
    //        } catch (e: Exception) {
    //            Log.e(TAG, "Error loading Data ${e.localizedMessage}")
    //        }
    //    }
    //}

}