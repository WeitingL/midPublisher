package com.weiting.midpublisher.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weiting.midpublisher.PublishViewModel
import com.weiting.midpublisher.database.FirebaseRepository

class PublishViewModelFactory(
    private val firebaseDataRepository: FirebaseRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(PublishViewModel::class.java) ->
                    PublishViewModel(firebaseDataRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}