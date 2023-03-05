package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentGettingBinding
import com.pra.navigation.databinding.FragmentLoginBinding
import com.pra.navigation.databinding.FragmentSplashBinding

class LoginFragment : Fragment() {

    private var mBinding: FragmentLoginBinding? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding?.button?.setOnClickListener {

            (activity as ConditionalActivity).sharePreference?.setBool("isLogin",true)
            val action = LoginFragmentDirections.actionLoginFragment2ToDashBoardFragment()
            findNavController().navigate(action)
        }
    }


}