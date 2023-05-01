package com.example.tidya.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrugModule {

    @Singleton
    @Provides
    fun getRepository(dao: DrugDao) : DrugRepository{
        return DrugRepository(dao)
    }

    @Singleton
    @Provides
    fun getDao(database: DrugDatabase) : DrugDao{
        return database.DrugDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : DrugDatabase {
        return Room.databaseBuilder(
            context.applicationContext,DrugDatabase::class.java,"GetDrug"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}
