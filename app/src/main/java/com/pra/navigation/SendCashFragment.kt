package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pra.navigation.databinding.FragmentSendCashBinding

class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    private var mBinding: FragmentSendCashBinding? = null

    private val args: SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentSendCashBinding.inflate(inflater, container, false);
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.receiverName

        mBinding?.etAmount?.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner, Observer {
            mBinding?.etAmount?.setText(it.toString())
        })


        mBinding?.tvReceiver?.text = "Send cash to $name"

        //  mBinding?.etAmount?.setText(amount.toString())

        mBinding?.btnSend?.setOnClickListener {
            val amount = mBinding?.etAmount?.text
            if (amount?.isEmpty()!!) {
                Toast.makeText(activity, "Amount is blank ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(
                name, amount.toString().toLong()
            )
            findNavController().navigate(action)
        }

        mBinding?.btnCancel?.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)

        }

        mBinding?.btnDone?.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }


    }
}