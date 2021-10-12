package com.weiting.midpublisher.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weiting.midpublisher.MainViewModel
import com.weiting.midpublisher.database.FirebaseDataRepository
import com.weiting.midpublisher.database.FirebaseRepository

class MainViewModelFactory(
    private val firebaseDataRepository: FirebaseRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(firebaseDataRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}