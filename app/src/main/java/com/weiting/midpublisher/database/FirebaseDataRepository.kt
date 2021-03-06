package com.weiting.midpublisher.database

import android.util.Log

class FirebaseDataRepository(private val firebaseDataSource: FirebaseSource): FirebaseRepository {

    override fun getArticle(): List<ArticleData> {
        Log.i("where is my data?", "FirebaseDataRepository is work")
        return firebaseDataSource.getArticle()
    }

    override fun postArticle(articleData: ArticleData){
        return firebaseDataSource.postArticle(articleData)
    }

    override fun getArticleId(): String {
        return firebaseDataSource.getArticleId()
    }

}