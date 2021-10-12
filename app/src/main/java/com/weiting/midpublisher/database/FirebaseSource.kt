package com.weiting.midpublisher.database

interface FirebaseSource {

    fun getArticle(): List<ArticleData>

    fun postArticle(articleData: ArticleData)

    fun getArticleId():String
}