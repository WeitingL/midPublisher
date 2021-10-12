package com.weiting.midpublisher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.database.ArticalData

class MainViewModel : ViewModel() {

    private val database = FirebaseFirestore.getInstance()

    private val _requestData = MutableLiveData<List<ArticalData>>()
    val requestData: LiveData<List<ArticalData>>
        get() = _requestData

    init {
        getRequestData()
    }

    private fun getRequestData() {
        Log.i("Get", "Get Data Start")

        database.collection("articles")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val list = result.toObjects(ArticalData::class.java)

                    _requestData.value = list
                    Log.i("get data", "$list")
                }
            }
            .addOnFailureListener { e ->
                Log.w("Error to get data", e)
            }


    }


}