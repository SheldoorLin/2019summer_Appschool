package com.example.android.trackmysleepquality.profiletraker

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
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

    private val _profile = database.getAllprofiles()

    private var _name = "123"

    var name = ObservableField<String>()
    var profile = ObservableField<LiveData<List<MyProfile>>>()

    init {
        initializeNowprofile()
        name.set(_name)
        profile.set(_profile)
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

//            thisprofile.value = getNowprofilefromDatabase()
            update(newProfile)
//            Log.i("save button", newProfile.howaboutEdit.toString())
//            Log.i("save button", newProfile.nameEdit.toString())
//            Log.i("save button", newProfile.nicknameEdit.toString())
//            thisprofile.value =getNowprofilefromDatabase()
        }
    }

    private suspend fun insert(profile: MyProfile) {
        withContext(Dispatchers.IO) {
            database.insert(profile)
            Log.i("save button", database.get(key = 1).toString())

        }
    }



    private suspend fun update(profile : MyProfile) {
        withContext(Dispatchers.IO) {
            database.update(profile)
            Log.i("save button", database.get(key = 30).toString())
        }
    }
}


