package com.pra.navigation

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
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
            if (receiverName.isEmpty()) {
                return@setOnClickListener
            }

            val pendinginIntent =
                findNavController().createDeepLink().setGraph(R.navigation.nav_graph)
                    .setDestination(R.id.sendCashFragment).setArguments(SendCashFragmentArgs(receiverName).toBundle())
                    .createPendingIntent()

            showNotification(pendinginIntent, receiverName)
            val action =
                ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(
                    receiverName
                )
            findNavController().navigate(action)
        }


        mBinding?.btnCancel?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showNotification(pendinginIntent: PendingIntent, receiverName: String) {

        val notification = NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications).setContentTitle("Complete Transaction")
            .setContentText("Send Money to $receiverName").setContentIntent(pendinginIntent)
            .setAutoCancel(true).build()

        NotificationManagerCompat.from(requireActivity()).notify(12, notification)
    }


}