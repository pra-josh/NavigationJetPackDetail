package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pra.navigation.databinding.FragmentNotificationBinding

class NotificationsFragment : Fragment() {

    private lateinit var mBinding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentNotificationBinding.inflate(layoutInflater);
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.lstNotification.adapter = ArrayAdapter(
            requireActivity(), android.R.layout.simple_list_item_1, getNotifications()
        )
    }

    private fun getNotifications(): List<String> {
        var mlist = mutableListOf<String>()
        for (i in 1..100) {
            mlist.add("Notification # $i")
        }
        return mlist
    }


}