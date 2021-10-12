package com.weiting.midpublisher

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.weiting.midpublisher.database.ArticleData

class PublishViewModel : ViewModel() {

    private val database = FirebaseFirestore.getInstance()

    fun getArticleInfo(articleData: ArticleData){
        database.collection("articles").document(articleData.id!!)
            .set(articleData)
            .addOnSuccessListener { documentReference ->
                Log.d("store success", "DocumentSnapshot added with ID: ${articleData.id}")
            }
            .addOnFailureListener { e ->
                Log.w("store failure", "Error adding document", e)
            }
    }

    fun getFirebaseId():String{
        return database.collection("articles").document().id
    }

}