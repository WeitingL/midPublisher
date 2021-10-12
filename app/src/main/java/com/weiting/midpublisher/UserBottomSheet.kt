package com.weiting.midpublisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.weiting.midpublisher.databinding.UserBottomsheetBinding

class UserBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            UserBottomsheetBinding.inflate(LayoutInflater.from(inflater.context), container, false)


        return binding.root
    }

}