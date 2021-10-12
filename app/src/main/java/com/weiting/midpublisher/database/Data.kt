package com.weiting.midpublisher.database

import java.util.*


data class ArticalData(
    val author: AuthorData? = null,
    val title: String? = null,
    val content: String? = null,
    val createTime: String? = null,
    val id: String,
    val category: String? = null

)

data class AuthorData(
    val email: String? = null,
    val id: String? = null,
    val name: String? = null
)