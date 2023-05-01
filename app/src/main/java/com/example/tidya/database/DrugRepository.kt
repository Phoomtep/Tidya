package com.example.tidya.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DrugRepository @Inject constructor(private val DrugDao : DrugDao) {

    fun getAllItems(): List<GetDrug> {
        return DrugDao.getAllDrugs()
    }

    suspend fun insertDrug(drug: GetDrug) {
        withContext(Dispatchers.IO) {
            DrugDao.insertDrug(drug)
        }
    }

    suspend fun deleteAll(drug: GetDrug) {
        withContext(Dispatchers.IO) {
            DrugDao.deleteAll()
        }
    }

    suspend fun update(drug: GetDrug){
        withContext(Dispatchers.IO) {
            DrugDao.update(drug)
        }
    }

    suspend fun updateStatusTrue(id : Int) {
        withContext(Dispatchers.IO) {
            DrugDao.updateStatusTrue(id)
        }
    }

    suspend fun updateStatusFalse(id : Int) {
        withContext(Dispatchers.IO) {
            DrugDao.updateStatusFalse(id)
        }
    }
}