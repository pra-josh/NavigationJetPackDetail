package com.pra.navigation

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var mBinding: FragmentSplashBinding? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentSplashBinding.inflate(inflater, container, false)
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bool = (activity as ConditionalActivity).sharePreference?.getBool("isLogin")!!

        Handler().postDelayed(Runnable {
            if (bool) {
                val action =
                    SplashFragmentDirections.actionSplashFragmentToDashBoardFragment()
                findNavController().navigate(action)
            } else {
                val action =
                    SplashFragmentDirections.actionSplashFragmentToGettingStartedFragment()
                findNavController().navigate(action)
            }

        }, 3000)
    }


}