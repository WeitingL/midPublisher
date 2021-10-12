package com.weiting.midpublisher

import android.app.Application

lateinit var application: PublicApplication

class PublicApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        application = this
    }


}