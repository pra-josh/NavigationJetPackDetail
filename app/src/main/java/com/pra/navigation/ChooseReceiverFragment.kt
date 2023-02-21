package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentChooseReceiverBinding

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {

    private var mBinding: FragmentChooseReceiverBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentChooseReceiverBinding.inflate(inflater, container, false)
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding?.btnNext?.setOnClickListener {
            val receiverName = mBinding?.etReceiverName?.text.toString()

            /*if (receiverName.isEmpty()) {

            }*/

            val action =
                ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(
                    receiverName,300)
            findNavController().navigate(action)
        }


        mBinding?.btnCancel?.setOnClickListener {

        }
    }


}