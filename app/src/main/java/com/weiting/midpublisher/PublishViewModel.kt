package com.weiting.midpublisher

import androidx.lifecycle.ViewModel
import com.weiting.midpublisher.database.ArticleData
import com.weiting.midpublisher.database.FirebaseRepository

class PublishViewModel(private val firebaseDataRepository: FirebaseRepository) : ViewModel() {

    fun getArticleInfo(articleData: ArticleData){
        firebaseDataRepository.postArticle(articleData)
    }

    fun getFirebaseId():String{
        return firebaseDataRepository.getArticleId()
    }

}