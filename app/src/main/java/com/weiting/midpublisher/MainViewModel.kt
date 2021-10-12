package com.weiting.midpublisher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.database.ArticleData

class MainViewModel : ViewModel() {

    private val database = FirebaseFirestore.getInstance()

    private val _requestData = MutableLiveData<List<ArticleData>>()
    val requestData: LiveData<List<ArticleData>>
        get() = _requestData

    private val _refreshState = MutableLiveData<Boolean>()
    val refreshState : LiveData<Boolean>
        get() = _refreshState

    init {
        getRequestData()
        _refreshState.value = false
    }

    private fun getRequestData() {
        Log.i("Get", "Get Data Start")

        database.collection("articles")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val list = result.toObjects(ArticleData::class.java)

                    _requestData.value = list
                    Log.i("get data", "$list")
                }
            }
            .addOnFailureListener { e ->
                Log.w("Error to get data", e)
            }
    }

    fun refreshData(){
        _refreshState.value = true
        getRequestData()
        _refreshState.value = false
    }


}