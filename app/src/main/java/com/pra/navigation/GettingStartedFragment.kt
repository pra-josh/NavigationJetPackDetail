package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentGettingBinding
import com.pra.navigation.databinding.FragmentSplashBinding

class GettingStartedFragment : Fragment(){

    private var mBinding:FragmentGettingBinding?=null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       super.onCreateView(inflater, container, savedInstanceState)
        mBinding=FragmentGettingBinding.inflate(inflater,container,false)
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mBinding?.button2?.setOnClickListener {
            val action = GettingStartedFragmentDirections.actionGettingStartedFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }



}