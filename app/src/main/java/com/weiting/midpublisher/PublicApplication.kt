package com.weiting.midpublisher

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.database.FirebaseRepository

lateinit var application: PublicApplication

class PublicApplication : Application() {

    lateinit var database: FirebaseFirestore

    val firebaseDataRepository: FirebaseRepository
        get() = FirebaseLocator.provideRepository(this)

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        database = FirebaseFirestore.getInstance()

        application = this
    }

}