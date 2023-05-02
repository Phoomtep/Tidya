package com.example.tidya.database

import androidx.room.*
import java.time.LocalDateTime

//val currentDateTime = LocalDateTime.now()
@Dao
interface DrugDao {


    @Query("SELECT * FROM GetDrug")
    fun getAllDrugs() : List<GetDrug>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrug(drug: GetDrug)

    @Query("DELETE FROM GetDrug")
    suspend fun deleteAll()

    @Update
    fun update(drug: GetDrug)

    @Query("UPDATE GetDrug SET Status = 1 WHERE id = :id")
    fun updateStatusTrue(id : Int)

    @Query("UPDATE GetDrug SET Status = 0 WHERE id = :id")
    fun updateStatusFalse(id : Int)

    @Query("DELETE FROM GetDrug WHERE id = :id")
    fun deleteData(id: Int)

}