package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentSettingsBinding
import com.pra.navigation.databinding.FragmentViewTransactionBinding

class SettingsFragment : Fragment() {

    private lateinit var mBinding: FragmentSettingsBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentSettingsBinding.inflate(inflater, container, false)
        return mBinding.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.etDefaultAmount.setText(SampleData.defaultAmount.value.toString())
        mBinding.btnSaveDefaultAmount.setOnClickListener {
            val default = mBinding.etDefaultAmount.text.toString().toLong()
            SampleData.defaultAmount.value = default
        }

        mBinding.btnAboutThisApp.setOnClickListener {
            val action = NavGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }


}