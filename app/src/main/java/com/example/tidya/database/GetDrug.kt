package com.example.tidya.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "GetDrug")
data class GetDrug(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val date : String,
    var Status : Boolean = false,
    var time : String
)