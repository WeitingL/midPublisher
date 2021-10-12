package com.weiting.midpublisher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weiting.midpublisher.database.ArticleData
import com.weiting.midpublisher.database.FirebaseRepository

class MainViewModel(private val firebaseDataRepository: FirebaseRepository) : ViewModel() {

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
        Log.i("where is my data?", "MainViewModel is work")
       _requestData.value = firebaseDataRepository.getArticle()
        Log.i("where is my data?", _requestData.value.toString())
    }

    fun refreshData(){
        _refreshState.value = true
        getRequestData()
        _refreshState.value = false
    }

}