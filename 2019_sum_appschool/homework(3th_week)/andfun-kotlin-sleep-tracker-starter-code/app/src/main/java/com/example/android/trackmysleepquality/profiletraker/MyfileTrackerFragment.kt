package com.example.android.trackmysleepquality.profiletraker

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.MyfileDatabase
import com.example.android.trackmysleepquality.databinding.FragmentMyfileTrackerBinding
import com.example.android.trackmysleepquality.databinding.FragmentSleepTrackerBinding

class MyfileTrackerFragment : Fragment() {

    /**
     * Called when the Fragment is ready to display content to the screen.
     *
     * This function uses DataBindingUtil to inflate R.layout.fragment_myfile_tracker.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentMyfileTrackerBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_myfile_tracker, container, false)
        val application=requireNotNull(this.activity).application

        val dataSource=MyfileDatabase.getInstance(application).myfileDatabaseDao

        val viewModelFactory=MyfileTrackerViewModelFactory(dataSource,application)

        val myfileTrackerViewModel=
                ViewModelProviders.of(
                        this,viewModelFactory).get(MyfileTrackerViewModel::class.java)
        binding.myfileTrackerViewModel = myfileTrackerViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }
}

