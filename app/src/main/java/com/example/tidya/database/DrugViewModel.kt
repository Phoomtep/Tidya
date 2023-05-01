package com.example.tidya.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrugViewModel @Inject constructor(private val repository: DrugRepository):ViewModel(){


    private val _drugs = MutableStateFlow(emptyList<GetDrug>())
    val drugs : StateFlow<List<GetDrug>> = _drugs

    init {
        viewModelScope.launch { _drugs.emit(repository.getAllItems())
        }
    }

    fun insertDrug(drug: GetDrug){
        viewModelScope.launch {
            repository.insertDrug(drug)
            _drugs.emit(repository.getAllItems())}
    }

    fun deleteAll(drug: GetDrug) {
        viewModelScope.launch {
            repository.deleteAll(drug)
            _drugs.emit(repository.getAllItems())}
    }

    /*fun updateStatus(id : Int){
        viewModelScope.launch {
            repository.updateStatus(id)
            _drugs.emit(repository.getAllItems())
        }
    }*/

    fun updateStatusTrue(id: Int) {
        viewModelScope.launch {
            repository.updateStatusTrue(id)
            _drugs.emit(repository.getAllItems())
        }

    }

    fun updateStatusFalse(id: Int) {
        viewModelScope.launch {
            repository.updateStatusFalse(id)
            _drugs.emit(repository.getAllItems())
        }

    }


}