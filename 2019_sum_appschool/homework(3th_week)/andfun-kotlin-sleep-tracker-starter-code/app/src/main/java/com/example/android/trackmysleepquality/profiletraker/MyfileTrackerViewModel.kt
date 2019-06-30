package com.example.android.trackmysleepquality.profiletraker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.trackmysleepquality.database.MyfileDatabaseDao

class MyfileTrackerViewModel (
        val database: MyfileDatabaseDao,
        application: Application) : AndroidViewModel(application) {

}
