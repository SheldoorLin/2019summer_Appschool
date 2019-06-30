package com.example.android.trackmysleepquality.profiletraker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.trackmysleepquality.database.MyfileDatabaseDao
import com.example.android.trackmysleepquality.sleeptracker.SleepTrackerViewModel

class MyfileTrackerViewModelFactory (
        private val dataSource : MyfileDatabaseDao,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyfileTrackerViewModel::class.java)) {
            return MyfileTrackerViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}