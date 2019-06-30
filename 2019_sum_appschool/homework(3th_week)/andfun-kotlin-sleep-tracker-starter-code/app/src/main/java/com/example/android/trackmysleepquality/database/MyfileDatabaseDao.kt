package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update



@Dao
interface MyfileDatabaseDao {

    @Insert
    fun insert(profile: MyProfile)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param night new value to write
     */
    @Update
    fun update(profile : MyProfile)

    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */
    @Query("SELECT * from my_profile_table WHERE profileId = :key")
    fun get(key: Long): MyProfile?

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM my_profile_table")
    fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM my_profile_table ORDER BY profileId DESC")
    fun getAllprofiles(): LiveData<List<MyProfile>>

    /**
     * Selects and returns the latest night.
     */
    @Query("SELECT * FROM my_profile_table ORDER BY profileId DESC LIMIT 1")
    fun getNowprofile(): MyProfile?

}