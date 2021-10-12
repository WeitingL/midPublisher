package com.weiting.midpublisher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.weiting.midpublisher.databinding.UserBottomsheetBinding

class UserBottomSheet : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            UserBottomsheetBinding.inflate(
                LayoutInflater.from(inflater.context), container, false
            )
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btEnter.setOnClickListener {
            if (checkInput(binding)) {
                viewModel.getUserData(
                    binding.edtEmail.text.toString(),
                    binding.edtID.text.toString(),
                    binding.edtName.text.toString()
                )
                Toast.makeText(context, "User Info Get!", Toast.LENGTH_LONG).show()
                //TODO back!!


            } else {
                Toast.makeText(
                    context,
                    "Something wrong, please checkout the info",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        return binding.root
    }

    private fun checkInput(binding: UserBottomsheetBinding): Boolean {
        return if (binding.edtEmail.text.isEmpty()) {
            false
        } else if (binding.edtID.text.isEmpty()) {
            false
        } else if (binding.edtName.text.isEmpty()) {
            false
        } else {
            true
        }

    }
}