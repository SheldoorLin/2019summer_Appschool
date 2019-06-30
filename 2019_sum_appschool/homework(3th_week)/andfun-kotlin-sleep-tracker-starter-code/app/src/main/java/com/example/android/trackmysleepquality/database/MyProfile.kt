package com.example.android.trackmysleepquality.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "my_profile_table")
data class MyProfile(
        @PrimaryKey(autoGenerate = true)
        var profileId: Long = 0L,

        @ColumnInfo(name = "name_edit")
        var nameEdit: String?,

        @ColumnInfo(name = "nickname_edit")
        var nicknameEdit: String?,

        @ColumnInfo(name = "how_about_me_edit")
        var howaboutEdit: String?
)