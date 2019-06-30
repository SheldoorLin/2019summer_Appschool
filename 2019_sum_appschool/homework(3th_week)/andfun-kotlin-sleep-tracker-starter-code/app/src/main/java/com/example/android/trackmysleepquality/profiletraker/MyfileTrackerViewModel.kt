package com.example.android.trackmysleepquality.profiletraker

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.trackmysleepquality.database.MyProfile
import com.example.android.trackmysleepquality.database.MyfileDatabaseDao
import kotlinx.coroutines.*

class MyfileTrackerViewModel(
        val database: MyfileDatabaseDao,
        application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var thisprofile = MutableLiveData<MyProfile?>()

    private val profiles = database.getAllprofiles()

    init {
        initializeNowprofile()
    }

    private fun initializeNowprofile() {
        uiScope.launch {
            thisprofile.value = getNowprofilefromDatabase()
        }
    }

    private suspend fun getNowprofilefromDatabase(): MyProfile? {
        return withContext(Dispatchers.IO) {
            var profile = database.getNewprofile()
            if (profile?.nameEdit.equals(null) ||
                    profile?.nicknameEdit.equals(null) || profile?.howaboutEdit.equals(null)) {
                profile = null
            }
            profile
        }
    }

//問題點
    fun onSaveTracking() {
        uiScope.launch {
            val newProfile = MyProfile(howaboutEdit = "123", nameEdit = "456", nicknameEdit = "789")
            insert(newProfile)

            thisprofile.value = getNowprofilefromDatabase()
//            update(newProfile)
//            thisprofile.value =getNowprofilefromDatabase()
        }
    }

    private suspend fun insert(profile: MyProfile) {
        withContext(Dispatchers.IO) {
            database.insert(profile)
        }
    }


    private suspend fun update(profile: MyProfile) {
        withContext(Dispatchers.IO) {
            database.update(profile)
        }
    }
}


