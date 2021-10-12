package com.weiting.midpublisher

import android.content.Context

object UserManager {

    val sharedPreference = application.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)

}