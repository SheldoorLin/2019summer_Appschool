package com.example.android.trackmysleepquality.profiletraker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.trackmysleepquality.database.MyProfile
import com.example.android.trackmysleepquality.database.MyfileDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MyfileTrackerViewModel (
        val database: MyfileDatabaseDao,
        application: Application) : AndroidViewModel(application) {

//    private var viewModelJob = Job()
//
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//
//    private var newprofile = MutableLiveData<MyProfile?>()
//
//    private val profiles = database.getAllprofiles()
//
//    }

}
