package com.weiting.midpublisher.database

import android.app.Application
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.application

object FirebaseDataSource : FirebaseSource {

    override fun getArticle(): List<ArticleData> {

        val list = mutableListOf<ArticleData>()
        val database = application.database

        database.collection("articles")
            .get()
            .addOnSuccessListener { result ->

                //為啥取不出來?! 我問號?!
                //為啥我換到publish就有資料了? 我更問號?
                val datalist = result.toObjects(ArticleData::class.java)

                list += datalist

//                for (i in 0 until datalist.size){
//                    list += datalist[i]
//                }

                Log.i("get data in FirebaseDataSource", "$list")
            }
            .addOnFailureListener { e ->
                Log.w("Error to get data", e)
            }

        Log.i("get data in FirebaseDataSource return", "$list")
        return list
    }

    override fun postArticle(articleData: ArticleData) {
        val database = application.database
        database.collection("articles").document(articleData.id!!)
            .set(articleData)
            .addOnSuccessListener { documentReference ->
                Log.d("store success", "DocumentSnapshot added with ID: ${articleData.id}")
            }
            .addOnFailureListener { e ->
                Log.w("store failure", "Error adding document", e)
            }

    }

    override fun getArticleId(): String {
        val database = application.database
        return database.collection("articles").document().id
    }
}