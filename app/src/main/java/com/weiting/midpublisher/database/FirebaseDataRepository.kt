package com.weiting.midpublisher.database

class FirebaseDataRepository(private val firebaseDataSource: FirebaseSource): FirebaseRepository {

    override fun getArticle(): List<ArticleData> {
        return firebaseDataSource.getArticle()
    }

    override fun postArticle(articleData: ArticleData){
        return firebaseDataSource.postArticle(articleData)
    }

    override fun getArticleId(): String {
        return firebaseDataSource.getArticleId()
    }

}