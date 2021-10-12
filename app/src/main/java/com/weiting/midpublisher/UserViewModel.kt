package com.weiting.midpublisher

import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    fun getUserData(email: String, id: String, name: String){

        UserManager.sharedPreference.edit()
            .putString("email", email)
            .putString("id", id)
            .putString("name", name)
            .apply()

    }

}