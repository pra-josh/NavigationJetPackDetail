package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pra.navigation.databinding.FragmentConfirmDialogBinding
import com.pra.navigation.databinding.FragmentHomeBinding
import com.pra.navigation.databinding.FragmentViewBalanceBinding

class ConfirmDialogFragment : BottomSheetDialogFragment(R.layout.fragment_confirm_dialog) {

    private var mBinding: FragmentConfirmDialogBinding? = null;
    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentConfirmDialogBinding.inflate(inflater, container, false);
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = args.title
        val amount = args.amount
        mBinding?.tvMessage?.text = "Do you want to Rs. $amount to $title"
        val navController = findNavController()
        mBinding?.btnNo?.setOnClickListener {
            dismiss()
        }

        mBinding?.btnYes?.setOnClickListener {
            Toast.makeText(activity, "$amount has been sent to $title", Toast.LENGTH_SHORT).show();
            dismiss()
        }

    }


}