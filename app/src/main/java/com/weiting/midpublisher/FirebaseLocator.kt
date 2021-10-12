package com.weiting.midpublisher

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.database.FirebaseDataRepository
import com.weiting.midpublisher.database.FirebaseDataSource
import com.weiting.midpublisher.database.FirebaseRepository

object FirebaseLocator {

    @Volatile
    var firebaseRepository: FirebaseRepository? = null

    fun provideRepository(context: Context): FirebaseRepository{
        synchronized(this){
            return firebaseRepository?: createRepository(context)
        }
    }

    private fun createRepository(context: Context): FirebaseRepository{
        return FirebaseDataRepository(FirebaseDataSource)
    }

}