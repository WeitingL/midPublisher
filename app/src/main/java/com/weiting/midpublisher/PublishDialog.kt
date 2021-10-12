package com.weiting.midpublisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import com.weiting.midpublisher.databinding.PublishPageBinding

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

        binding.btSubmit.setOnClickListener {
            UserBottomSheet().show(parentFragmentManager, "Login")
        }


        return binding.root
    }

    private fun reSize(){
        if (null != dialog){
            val window = dialog!!.window

            val layoutParams = dialog!!.window?.attributes
            layoutParams?.height = 1500
            layoutParams?.width = 1000
            if (dialog != null){
                window?.setLayout(layoutParams!!.width, layoutParams.height)
            }


        }
    }


}