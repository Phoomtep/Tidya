package com.example.tidya.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GetDrug::class], version = 1, exportSchema = false)
abstract class DrugDatabase : RoomDatabase(){

    abstract fun DrugDao() : DrugDao


}