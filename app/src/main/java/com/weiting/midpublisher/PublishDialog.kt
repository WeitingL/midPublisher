package com.weiting.midpublisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.weiting.midpublisher.database.ArticleData
import com.weiting.midpublisher.database.AuthorData
import com.weiting.midpublisher.databinding.PublishPageBinding
import java.text.SimpleDateFormat
import java.util.*

class PublishDialog : AppCompatDialogFragment() {


    override fun onStart() {
        super.onStart()
        reSize()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            PublishPageBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this).get(PublishViewModel::class.java)

        binding.btSubmit.setOnClickListener {
            when (UserManager.sharedPreference.getString("id", null).isNullOrEmpty()) {
                true -> {
                    UserBottomSheet().show(parentFragmentManager, "Login")
                }
                false -> {
                    val articleData = ArticleData(
                        AuthorData(
                            UserManager.sharedPreference.getString("email", null),
                            UserManager.sharedPreference.getString("id", null),
                            UserManager.sharedPreference.getString("name", null)
                        ),
                        title = binding.tvPublishTitle.text.toString(),
                        content = binding.etvContent.text.toString(),
                        created = SimpleDateFormat("yyyy.MM.dd hh:mm", Locale.TAIWAN).format(
                            Calendar.getInstance().timeInMillis
                        ),
                        id = viewModel.getFirebaseId(),
                        category = getCategory(binding)
                    )

                    viewModel.getArticleInfo(articleData)
                    Toast.makeText(context, "Article is Published!", Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }

    private fun reSize() {
        if (null != dialog) {
            val window = dialog!!.window

            val layoutParams = dialog!!.window?.attributes
            layoutParams?.height = 1500
            layoutParams?.width = 1000
            if (dialog != null) {
                window?.setLayout(layoutParams!!.width, layoutParams.height)
            }
        }
    }

    private fun getCategory(binding: PublishPageBinding): String {
        return when (binding.spCategory.selectedItemPosition) {
            0 -> "Beauty"
            1 -> "Gossiping"
            2 -> "IU"
            else -> "Other"
        }
    }


}