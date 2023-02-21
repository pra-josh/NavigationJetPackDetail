package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        val amount = args.amount

        mBinding?.tvReceiver?.text = "Send cash to $name"

        mBinding?.etAmount?.setText(amount.toString())

        mBinding?.btnSend?.setOnClickListener {

            Toast.makeText(activity, "Send ", Toast.LENGTH_LONG).show()
        }

        mBinding?.btnCancel?.setOnClickListener {
            Toast.makeText(activity, "Cancel ", Toast.LENGTH_LONG).show()
        }

        mBinding?.btnDone?.setOnClickListener {
            Toast.makeText(activity, "Done ", Toast.LENGTH_LONG).show()
        }


    }
}