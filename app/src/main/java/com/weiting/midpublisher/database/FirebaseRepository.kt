package com.weiting.midpublisher.database

interface FirebaseRepository {

    fun getArticle(): List<ArticleData>

    fun postArticle(articleData: ArticleData)

    fun getArticleId():String
}