package com.weiting.midpublisher.database

import java.util.*


data class ArticleData(
    val author: AuthorData? = null,
    val title: String? = null,
    val content: String? = null,
    val created: String? = null,
    val id: String? = null,
    val category: String? = null

)

data class AuthorData(
    val email: String? = null,
    val id: String? = null,
    val name: String? = null
)